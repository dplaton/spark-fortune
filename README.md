Spark Fortune - A web wrapper for the popular bash program
===

This is a small wrapper around the popular bash command "fortune". This was built in a few hours with the sole purpose of having fun while testing out Spark micro-framework.

## Prerequisites

* Java 8
* Maven
* Fortune (so this won't probably run on Windows)


## Building the source code
To build the source code run a ``mvn clean package`` in the root folder, then a ``java -jar spark-fortune-1.0-jar-with-dependencies.jar`` in the target folder.

## Using docker

You can spawn a [Docker](http://www.docker.com) container using the attached Dockerfile. Just use 

```
docker build -t spark-fortune .
``` 

to build the container (first build will take some time to set up) and then 

```
docker run -d -p 4567:4567 spark-fortune
``` 

to run it.

## Endpoints
### Root endpoint
Does nothing

### Echo endpoint

```
curl -i --data "message=your message here" http://localhost:4567/echo 
```
will echo the message back

### Fortune endpoint
```
curl -i http://localhost:4567/fortune
```
Will return a "fortune" message. Use the ``http://localhost:4567/fortune/offensive`` to get the good ones.



##Useful links:

* [Spark Java documentation](http://sparkjava.com/documentation.html)
* [Getting started with Spark and Docker](https://sparktutorials.github.io/2015/04/14/getting-started-with-spark-and-docker.html)