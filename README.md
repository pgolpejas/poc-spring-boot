![coverage](.github/badges/jacoco.svg)
![branches](.github/badges/jacoco.svg)
# README #

## What is this service for? ##

* POC with:
  * Java 17
  * Spring boot 3.1.0
  * Hexagonal Architecture
  * Locust

## How to build and run this service ##

### Pre-requisites ###

In order to build this service the following software should be installed and added to your PATH:

- Java version 17
- Apache Maven 3 (3.8.4+ recommended) (<https://maven.apache.org/download.cgi>)
- Docker (optional, only for locust)

### Building and running ###
First, compile and generate the jar artifact.
```
mvn clean install
```
At this point you could run locally your service with:
```
java -jar target/poc-spring-boot-0.0.1.jar
```
Once started, the service can be reached at <http://localhost:8080>.

## Coverage ## 

Run coverage with maven (docker-compose does not need to be running)
```
mvn clean verify
```

Open target/site/jacoco-ut/index.html and check coverage

## Performance test with locust ## 

Running in Docker from /test/resources/locust
https://docs.locust.io/en/stable/running-in-docker.html

```
docker run -p 8089:8089 -v $PWD:/mnt/locust locustio/locust -f /mnt/locust/locustfile.py
```

Windows version
```
docker run -p 8089:8089 --mount type=bind,source=$pwd,target=/mnt/locust locustio/locust -f /mnt/locust/locustfile.py
```

if you need another instance to test on another port
```
docker run -p 8090:8089 -v $PWD:/mnt/locust locustio/locust -f /mnt/locust/locustfile.py
```
