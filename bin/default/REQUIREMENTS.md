# Sprint Boot Practice 

## Requirements

1. Create a Spring Boot application with a "Hello World" REST endpoint.
 This project will contain all the following REST endpoints also.

1. Add a REST endpoint that accepts a JSON object containing a paragraph
 of text and returns a JSON array of objects. The returned objects represent the
 unique words from the supplied paragraph along with a count of the number of
 occurrences. The array of objects must be sorted alphabetically

1. Add a REST endpoint that accepts a number, N, and returns a JSON array
 with the first N Fibonacci numbers. Please use the recursive form of Fibonacci.

1. Add a REST endpoint that creates two threads that become deadlocked
 with each other. Use the REST function to monitor the two threads and detect
 the deadlock, i.e. neither thread exits after a timeout of your choosing.

1. Add three REST endpoints that add, query, and delete rows in a
 database. Please use the HyperSQL (hsqldb.org) database dependency for an
 in-process database. Initialize the database when your Spring Boot application
 starts.
 Hint: [HyperSQL](http://www.programmingforfuture.com/2011/02/in-process-mode-of-hsqldb-in-web.html)

1. Finally, create a REST endpoint that queries an external REST
 service using Spring RestTemplate. The response should be returned to the
 caller. Use this external service: [typicode](https://jsonplaceholder.typicode.com/posts)

## TODO

- [ ] OpenAPI spec
- [ ] Code  comments, JavaDocs
- [ ] Logging
- [ ] Unit tests >= 50% coverage
- [ ] Mocking with JMockit
- [ ] Maven or Gradle build file
- [ ] README.md provides all the information necessary to build, run, and test
 your project from the command line.

NOTE: Please document how to call these REST endpoints in your README.md with
curl command.
