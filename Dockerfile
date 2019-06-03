FROM openjdk:8-jre-alpine
MAINTAINER Jonas Lins <jonaslinsj@gmail.com>

COPY /target/*.jar app.jar

#RUN ./mvnw package -B
ENTRYPOINT java -jar app.jar

EXPOSE 8080