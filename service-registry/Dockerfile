FROM eclipse-temurin:17
LABEL mentainer="foo@example.com"
WORKDIR /app
COPY build/libs/service-registry-0.0.1-SNAPSHOT.jar /app/service-registry.jar
ENTRYPOINT ["java", "-jar", "service-registry.jar"]