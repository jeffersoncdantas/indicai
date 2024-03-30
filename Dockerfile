# FROM ubuntu:latest AS build

# RUN apt-get update
# RUN apt-get install openjdk-17-jdk -y
# COPY . .

# RUN apt-get install maven -y
# RUN mvn clean install

# FROM openjdk:17-slim

# EXPOSE 80

# COPY --from=build target/indicai-0.0.1-SNAPSHOT.jar app.jar

# ENTRYPOINT ["java", "-jar", "app.jar"]

FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/deploy_ghactions-1.0.0.jar deploy_ghactions-1.0.0.jar
EXPOSE 8080
CMD ["java", "-jar", "deploy_ghactions-1.0.0.jar"]