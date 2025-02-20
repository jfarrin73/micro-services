FROM eclipse-temurin:17
LABEL mentainer="foo@example.com"
WORKDIR /app
COPY build/libs/api-gateway-0.0.1-SNAPSHOT.jar /app/api-gateway.jar
ENTRYPOINT ["java", "-jar", "api-gateway.jar"]