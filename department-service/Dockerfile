FROM eclipse-temurin:17
LABEL mentainer="foo@example.com"
WORKDIR /app
COPY build/libs/department-service-0.0.1-SNAPSHOT.jar /app/department-service.jar
ENTRYPOINT ["java", "-jar", "department-service.jar"]