# Getting Started
A simple Spring Boot application to demonstrate the bug in `@TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)`

When a user tries to hit a service method annotated with `@Transactional` in an `@TransactionalEventListener` they will receive an error:

```text
Caused by: org.neo4j.driver.exceptions.ClientException: Cannot run more queries in this transaction, it has been committed
```

## Dependencies
The application requires an instance of neo4j.  All configuration is in `application.properties`.

### Running the project
Run the following to start the webapp:

```shell
./gradlew bootRun
```

### Hitting the webapp
Run the following to hit the webapp and trigger the error:

```shell
curl --location --request POST 'localhost:8080/api/object?id=10'
```
