FROM eclipse-temurin:21-jdk-jammy
WORKDIR /app
COPY target/backend-1.0-SNAPSHOT.jar app.jar
EXPOSE 8083
ENTRYPOINT ["java","-jar","app.jar"]