FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /calculated

# Copy the Spring Boot application JAR file to the container
COPY target/websc-0.0.1-SNAPSHOT.jar app.jar

# Expose the port that your Spring Boot application runs on
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]