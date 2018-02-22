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

```console
gradle test jacocoTestReport
```

This runs the unit tests and the coverage repot. The coverage report
is located in `./build/reports/jacoco/test/html/index.html`.

## API Use

### Greeter Endpoint

The "greeter" endpoint returns a greeting in either spanish or english,
depending on the "content-language" HTTP header. The header defaults
to English from the USA, if none is specified. Also, only English and
Spanish are supported, if any other language is specified then it will
return the English greeting.

Request for the greeting endpoint (spanish message):

```bash
curl -H "content-language: es" http://localhost:8888/api/v1/greeter
```

response:

```bash
{"content":"Hola Mundo!","locale":"es"}
```

Request for the greeting endpoint (english message):

```bash
curl -H "content-language: en-US" http://localhost:8888/api/v1/greeter
```

response:

```bash
{"content":"Hello World!","locale":"en_US"}
```

### Text Analysis Endpoint (word frequency)

Request for work frequency:

<!-- markdownlint-disable MD013 -->

```bash
curl -v http://localhost:8888/api/v1/word_frequency -H "content-type: application/json" -d "{\"text\":\"For who thoroughly her boy estimating conviction. Removed demands expense account in outward tedious do. Particular way thoroughly unaffected projection favourable mrs can projecting own. Thirty it matter enable become admire in giving. See resolved goodness felicity shy civility domestic had but. Drawings offended yet answered jennings perceive laughing six did far\"}"
```

<!-- markdownlint-enable MD013 -->

Response:

```bash
[
    {
        "account": 1
    },
    {
        "admire": 1
    },
    {
        "answered": 1
    },
    {
        "become": 1
    },
    {
        "boy": 1
    },
    {
        "but": 1
    },
    {
        "can": 1
    },
    {
        "civility": 1
    },
    {
        "conviction": 1
    },
    {
        "demands": 1
    },
    {
        "did": 1
    },
    {
        "do": 1
    },
    {
        "domestic": 1
    },
    {
        "drawings": 1
    },
    {
        "enable": 1
    },
    {
        "estimating": 1
    },
    {
        "expense": 1
    },
    {
        "far": 1
    },
    {
        "favourable": 1
    },
    {
        "felicity": 1
    },
    {
        "for": 1
    },
    {
        "giving": 1
    },
    {
        "goodness": 1
    },
    {
        "had": 1
    },
    {
        "her": 1
    },
    {
        "in": 2
    },
    {
        "it": 1
    },
    {
        "jennings": 1
    },
    {
        "laughing": 1
    },
    {
        "matter": 1
    },
    {
        "mrs": 1
    },
    {
        "offended": 1
    },
    {
        "outward": 1
    },
    {
        "own": 1
    },
    {
        "particular": 1
    },
    {
        "perceive": 1
    },
    {
        "projecting": 1
    },
    {
        "projection": 1
    },
    {
        "removed": 1
    },
    {
        "resolved": 1
    },
    {
        "see": 1
    },
    {
        "shy": 1
    },
    {
        "six": 1
    },
    {
        "tedious": 1
    },
    {
        "thirty": 1
    },
    {
        "thoroughly": 2
    },
    {
        "unaffected": 1
    },
    {
        "way": 1
    },
    {
        "who": 1
    },
    {
        "yet": 1
    }
]
```

To web site [randomtextgenerator](http://randomtextgenerator.com/) can be used
to generate random text to be used to test this endpoint.

### Math Endpoint, Fibonacci Sequence

To call the API that returns a Fibonacci sequence:

```bash
curl -v http://localhost:8888/api/v1/math/fibonacci?numTerms=8
```

where `numTerms` (required parameter) is how many terms to include in the
Fibonacci sequence that is returned. For example, the request above would
return the JSON document:

```bash
[0,1,1,2,3,5,8,13]
```

### Create, Get and Delete Resources from Database Endpoint

The resource defined for this excercise is a `device`. A `device`
has attributes:

- id

- name (required)

- description

- creationDate

To create a device resource instance:

```bash
curl http://localhost:8888/api/v1/devices -H "Content-Type: application/json;charset=utf-8" -d "{\"name\":\"door sensor\"}"
```

e.g.:

```bash
curl -v http://localhost:8888/api/v1/devices -H "Content-Type: application/json;charset=utf-8" -d "{\"name\":\"door sensor\"}"
*   Trying ::1...
* TCP_NODELAY set
* Connected to localhost (::1) port 8888 (#0)
> POST /api/v1/devices HTTP/1.1
> Host: localhost:8888
> User-Agent: curl/7.54.0
> Accept: */*
> Content-Type: application/json;charset=utf-8
> Content-Length: 22
>
* upload completely sent off: 22 out of 22 bytes
< HTTP/1.1 201 Created
< Date: Thu, 22 Feb 2018 01:20:24 GMT
< X-Application-Context: exercise:8888
< Location: http://localhost:8888/api/v1/devices/1
< Content-Type: application/json;charset=utf-8
< Transfer-Encoding: chunked
<
* Connection #0 to host localhost left intact
```

To delete a device:

```bash
curl -X DELETE http://localhost:8888/api/v1/devices/1 
```

The command above will delete device with id=1.

Delete supports the "Prefer" HTTP header, if the delete request
set prefer to "return=representation" then the delete operation
will return the representation for the device that was just deleted.

e.g.:


```bash
curl -X DELETE http://localhost:8888/api/v1/devices/1 -H "prefer:return=representation" 
```

e.g.:

```bash
curl -X DELETE http://localhost:8888/api/v1/devices/1 -H "prefer:return=representation"
{"id":1,"name":"door sensor","description":null,"creationDate":1519262907900}
```

To get a device:

```bash
curl http://localhost:8888/api/v1/devices/1 
```

e.g.:

```bash
curl http://localhost:8888/api/v1/devices/1
{"id":1,"name":"door sensor","description":null,"creationDate":1519262587161}
```

To get all devices:

```bash
curl http://localhost:8888/api/v1/devices 
```

e.g.:

```bash
curl http://localhost:8888/api/v1/devices
[{"id":1,"name":"door sensor","description":null,"creationDate":1519263089954},{"id":3,"name":"garage sensor","description":null,"creationDate":1519263103789},{"id":4,"name":"temperature sensor","description":null,"creationDate":1519263111550},{"id":5,"name":"water leak sensor","description":null,"creationDate":1519263118421},{"id":2,"name":"window sensor","description":null,"creationDate":1519263097977}]
```

formatted JSON result for readability:

```json
curl http: //localhost:8888/api/v1/devices
	[{
		"id": 1,
		"name": "door sensor",
		"description": null,
		"creationDate": 1519263089954
	}, {
		"id": 3,
		"name": "garage sensor",
		"description": null,
		"creationDate": 1519263103789
	}, {
		"id": 4,
		"name": "temperature sensor",
		"description": null,
		"creationDate": 1519263111550
	}, {
		"id": 5,
		"name": "water leak sensor",
		"description": null,
		"creationDate": 1519263118421
	}, {
		"id": 2,
		"name": "window sensor",
		"description": null,
		"creationDate": 1519263097977
	}]
```

## Log Files

Log files are located under `./logs`. All application logging is recorded in
the file `exercise.json` (structured logging). The log configuration is contained
in the `./src/main/resources/logback.xml` file.

## Git (CI is a TODO)

Branches:

- master: current work, new features and bug fixes
 commits pushed or feature branch merges into master results in a *snapshot* published

- release: versions to be released
 commits pushed to the release branch results in a stable *release* published

Feature branches of the master branch for work related to individual features.

Releases and snapshots are only published is all tests have succeeded.

## Other
- Actuator is enabled with the management endpoints in a different port (8899) from
  the application port (8888). JMX is enabled to be able to run `jconsole`, which
  allows for easy monitoring of memory, CPU, thread counts, etc.

- 
