# Use lightweight Java 26 runtime
FROM eclipse-temurin:26-jdk

# Set working directory inside container
WORKDIR /app

# Copy the built JAR file
COPY target/*.jar app.jar

# Expose app port
EXPOSE 8080

# Run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]






