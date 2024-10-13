# Stage 1: Build the application with Gradle
FROM gradle:7.5-jdk17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the Gradle project files
COPY build.gradle.kts settings.gradle.kts /app/

# Copy the source code to the container
COPY src /app/src

# Build the application to create the JAR file
RUN gradle bootJar --no-daemon

# Stage 2: Create the final slim image
FROM eclipse-temurin:17-jre-alpine

# Set the working directory in the final image
WORKDIR /app

# Copy the JAR file from the first stage
COPY --from=build /app/build/libs/*.jar /app/app.jar

# Expose the port your Spring Boot application is running on
EXPOSE 8080

# Set the entry point to run the application
CMD ["java", "-jar", "/app/app.jar"]
