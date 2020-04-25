package com.github.daggerok.backend;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import lombok.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.data.annotation.Id;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.Map;
import java.util.UUID;

@With
@Value
@Table("my_users")
class MyUser {
  @Id UUID id;
  String name;
}

interface MyUserRepository extends ReactiveCrudRepository<MyUser, UUID> {}

@Data
@NoArgsConstructor
class SaveMyUserRequest {
  private UUID id;
  private String name;
}

@SpringBootApplication
@RequiredArgsConstructor
@EnableR2dbcRepositories
@EnableTransactionManagement
public class BackendApplication extends AbstractR2dbcConfiguration {

  final Environment environment;

  @Override
  public ConnectionFactory connectionFactory() {
    return ConnectionFactories.find(
        ConnectionFactoryOptions.builder()
                                .option(ConnectionFactoryOptions.DRIVER, "postgres")
                                .option(ConnectionFactoryOptions.HOST, environment.getProperty("POSTGRES_HOST", "127.0.0.1"))
                                .option(ConnectionFactoryOptions.PORT, Integer.parseInt(environment.getProperty("POSTGRES_PORT", "5432")))
                                .option(ConnectionFactoryOptions.USER, environment.getProperty("POSTGRES_USER", "postgres"))
                                .option(ConnectionFactoryOptions.PASSWORD, environment.getProperty("POSTGRES_USER", "postgres"))
                                .option(ConnectionFactoryOptions.DATABASE, environment.getProperty("POSTGRES_DB", "postgres"))
                                .build()
    );
  }

  @Bean
  RouterFunction<ServerResponse> r(DatabaseClient databaseClient,
                                   MyUserRepository myUserRepository) {
    return RouterFunctions
        .route()
        .POST("/", serverRequest -> ServerResponse.ok().body(
            serverRequest.bodyToMono(SaveMyUserRequest.class)
                         .map(r -> new MyUser(r.getId(), r.getName()))
                         .flatMap(myUserRepository::save), MyUser.class))
        .GET("/", serverRequest -> ServerResponse.ok().body(
            myUserRepository.findAll(), MyUser.class))
        .GET("/**", serverRequest -> ServerResponse.ok().body(
            databaseClient.execute("SELECT 1;").fetch().all(), Map.class))
        .build();
  }

  public static void main(String[] args) {
    SpringApplication.run(BackendApplication.class, args);
  }
}
