# start with the Java 8 container
FROM java:8

# Install maven
RUN apt-get update
RUN apt-get install -y maven

# Install fortune
RUN apt-get install -y fortune

ENV PATH "/usr/games":$PATH

WORKDIR /spark-java-src

# Prepare maven project
ADD pom.xml /spark-java-src/pom.xml
RUN ["mvn","dependency:resolve"]
RUN ["mvn","verify"]

ADD src /spark-java-src/src
RUN ["mvn","clean", "package"]

# expose the default Spark port
EXPOSE 4567

# run the server
CMD ["/usr/lib/jvm/java-8-openjdk-amd64/bin/java","-jar","target/spark-fortune-1.0-jar-with-dependencies.jar"]
