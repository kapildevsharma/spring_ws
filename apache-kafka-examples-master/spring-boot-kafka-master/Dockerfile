# Use a minimal base image
FROM openjdk:8-jre-slim

# Add metadata
LABEL maintainer="spring_kafka_application"

# Set a working directory
WORKDIR /app

# Copy the JAR file into the container
COPY target/spring-boot-with-kafka-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 8083

# Define the entry point
ENTRYPOINT ["java", "-jar", "/app/app.jar"]