# spring-boot micrometer prometheus grafana [![CI](https://github.com/daggerok/boot-micrometer-prometheus-grafana-monitoring/workflows/CI/badge.svg)](https://github.com/daggerok/boot-micrometer-prometheus-grafana-monitoring/actions?query=workflow%3ACI)
Monitor spring-boot apps with actuator, micrometer, prometheus and grafana...

## build and run system

```bash
./mvnw -f docker-compose -P postgres-start
./mvnw -f backend package jib:dockerBuild
./mvnw -f docker-compose -P backend-start,prometheus-start,grafana-start
```

## examine some rest calls (monitoring test data)

```bash
curl -sS 0:8080 | jq '.'
http :8080 name=ololo
http :8080 name=trololo
http :8080
```

## grafana

### setup

* open http://127.0.0.1:3000/
* login as `admin` / `admin`
* set a new password and confirm

### configure prometheus datasource

* click on `Add data source`
* select `prometheus`
* set URL: `http://prometheus:9090`
* set Query timeout: `5s`
* finally, click button: `Save & Test`
* verify success: `Data source is working`
* click `Dashboards` tab
* create one for `http_server_requests_seconds_count` query

## cleanup

```bash
./mvnw -f docker-compose -P down
```

## resources

* [YouTube: Kubernetes Master Class: Monitoring and Alerting with Prometheus & Grafana](https://www.youtube.com/watch?v=OQojdJL48S4&feature=youtu.be&t=1750)
* https://dzone.com/articles/monitoring-using-spring-boot-20-prometheus-and-gra
* [Docker Hub Prometheus](https://hub.docker.com/r/prom/prometheus/)
* [Spring Boot Actuator Metrics](https://docs.spring.io/spring-metrics/docs/current/public/prometheus)
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
