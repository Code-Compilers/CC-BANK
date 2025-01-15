# Use a base image with Java
FROM openjdk:21-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the Maven project file
COPY pom.xml .

# Copy the source code
COPY src ./src

# Package the application
RUN ./mvnw clean package -DskipTests

# Set the startup command
CMD ["java", "-jar", "target/CC-BANK-0.0.1-SNAPSHOT.jar"]