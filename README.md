# Getting Started
A simple Spring Boot application to demonstrate the bug (intermittently deletes object after save call)

## Dependencies
The application requires an instance of neo4j.  All configuration is in `application.properties`.

### Running the project
Run the following to start the webapp:

```shell
./gradlew bootRun
```

### Hitting the webapp
Run the following to hit the webapp and may trigger the error:

```shell

curl -XPOST "http://localhost:8080/api/my?id=1"
curl -XPOST "http://localhost:8080/api/my?id=unchecked"
curl -XPOST "http://localhost:8080/api/my?id=checked"
 
```

