FROM eclipse-temurin:17-jre-alpine
RUN mkdir /api
WORKDIR /api
COPY ./build/libs/covid-api-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD ["java", "-Dspring.profiles.active=docker", "-jar","covid-api-0.0.1-SNAPSHOT.jar"]