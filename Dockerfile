# Build stage
FROM amazoncorretto:17 AS builder
WORKDIR /app
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

# Fix line endings and set permissions
RUN sed -i 's/\r$//' mvnw && chmod +x mvnw

COPY src src
RUN ./mvnw clean package -DskipTests

# Runtime stage
FROM amazoncorretto:17
WORKDIR /app
COPY --from=builder /app/target/*.jar application.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Xmx2048M", "-jar", "application.jar"]
