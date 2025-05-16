# ----------------------------
# Stage 1: Build with Ubuntu, Maven, JDK
# ----------------------------
    FROM ubuntu:22.04 AS builder

    LABEL authors="saikr"
    ENV DEBIAN_FRONTEND=noninteractive
    
    # Set working directory
    WORKDIR /books
    
    # Install Maven and OpenJDK
    RUN apt update && \
        apt install -y maven openjdk-17-jdk && \
        apt clean
    
    # Copy source code
    COPY . .
    
    # Build the Spring Boot application
    RUN mvn clean package -DskipTests
    
    
    # ----------------------------
    # Stage 2: Final distroless image (secure, minimal)
    # ----------------------------
    FROM gcr.io/distroless/java17-debian11
    
    WORKDIR /app
    
    # Copy the JAR from the builder stage
    COPY --from=builder /books/target/*.jar app.jar
    
    # Expose the app port (optional if using ECS portMappings)
    EXPOSE 8080
    
    # Run the Spring Boot app
    CMD ["app.jar"]
    