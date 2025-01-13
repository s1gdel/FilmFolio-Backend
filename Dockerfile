# Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:17-jdk-jammy

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project files
COPY pom.xml .
COPY src ./src

# Download dependencies and build the application
RUN apt-get update && apt-get install -y maven && \
    mvn dependency:go-offline && \
    mvn clean package -DskipTests

# Expose the port the app runs on
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "target/learn-0.0.1-SNAPSHOT.jar"]
