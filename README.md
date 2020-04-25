# spring-boot micrometer prometheus grafana [![CI](https://github.com/daggerok/boot-micrometer-prometheus-grafana-monitoring/workflows/CI/badge.svg)](https://github.com/daggerok/boot-micrometer-prometheus-grafana-monitoring/actions?query=workflow%3ACI)
Monitor spring-boot apps with actuator, micrometer, prometheus and grafana...

```bash
./mvnw -f docker-compose -P postgres-start
./mvnw -f backend package jib:dockerBuild
./mvnw -f docker-compose -P backend-start

curl -sS 0:8080 | jq '.'
http :8080 name=ololo
http :8080 name=trololo
http :8080

./mvnw -f docker-compose -P down
```

## resources

* [R2DBC migrations (require java >= 11 and spring-boot >= 2.3.0.M3)](https://github.com/nkonev/r2dbc-migrate)
* [R2DBC migrations example](https://github.com/nkonev/r2dbc-migrate-example/blob/master/pom.xml)
* [YouTube: Production-Ready Spring Boot Applications](https://www.youtube.com/watch?v=SSu7V-S5yec&feature=youtu.be&t=2132s)
* https://www.callicoder.com/spring-boot-actuator-metrics-monitoring-dashboard-prometheus-grafana/
<!--
* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.3.0.M4/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.3.0.M4/maven-plugin/reference/html/#build-image)
* [Coroutines section of the Spring Framework Documentation](https://docs.spring.io/spring/docs/5.2.5.RELEASE/spring-framework-reference/languages.html#coroutines)
* [Flyway Migration](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/reference/htmlsingle/#howto-execute-flyway-database-migrations-on-startup)
* [Spring Configuration Processor](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/reference/htmlsingle/#configuration-metadata-annotation-processor)
* [Spring Data R2DBC](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/reference/html/spring-boot-features.html#boot-features-r2dbc)
* [JDBC API](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/reference/htmlsingle/#boot-features-sql)
* [Spring Data JDBC](https://docs.spring.io/spring-data/jdbc/docs/current/reference/html/)
* [Acessing data with R2DBC](https://spring.io/guides/gs/accessing-data-r2dbc/)
* [Accessing Relational Data using JDBC with Spring](https://spring.io/guides/gs/relational-data-access/)
* [Managing Transactions](https://spring.io/guides/gs/managing-transactions/)
* [Using Spring Data JDBC](https://github.com/spring-projects/spring-data-examples/tree/master/jdbc/basics)
* [R2DBC Homepage](https://r2dbc.io)
-->
