# Spring Boot Practice

Practice code to learn Spring Boot.

## Build

To build execute the command:

```console
gradle build
```

This will create an executable JAR file in the `./build/libs` directory named
`spring-exercise-0.8.0.jar`.

## Run

To run the application:

```console
gradle run
```

This will run the application and listen on port TCP:8888. The application can
also be run by executing the JAR file with command:

```console
java -jar ./build/libs/spring-exercise-0.8.0.jar
```

## Test

## API

### Greeting Endpoint

To call the greeting endpoint run:

```console
curl -v http://localhost:8888/api/v1/
```

## Git

Branches:

- master: current work, new features and bug fixes
 commits pushed or feature branch merges into master results in a *snapshot* published

- release: versions to be released
 commits pushed to the release branch results in a stable *release* published

Feature branches of the master branch for work related to individual features.

Releases and snapshots are only published is all tests have succeeded.
