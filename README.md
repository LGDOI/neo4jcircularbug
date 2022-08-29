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

curl -XDELETE "http://localhost:8080/api/range"
for id in {1..150}; do
  curl -s -XPOST "http://localhost:8080/api/range?id=${id}" | jq .
done
for id in {1..150}; do
  curl -s -XPATCH "http://localhost:8080/api/range?id=${id}" | jq .
done

```

