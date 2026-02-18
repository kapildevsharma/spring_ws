#FROM openjdk:8
FROM openjdk:8-jdk-alpine
MAINTAINER kapil
ARG JAR_FILE=docker-spring-test.jar
ADD ${JAR_FILE} app.jar
EXPOSE 8090
ENTRYPOINT ["java, "-jar", "docker-spring-test.jar"]