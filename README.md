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

for id in {1..50}; do
  curl -XPOST "http://localhost:8080/api/laptop?id=${id}" | jq .
done
for id in {1..30}; do
  curl -XPATCH "http://localhost:8080/api/laptop?id=${id}" | jq .
done

```

