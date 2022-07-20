FROM openjdk:11-jre-slim-bullseye
COPY build/libs/ensyu-end.jar ensyu-end.jar
ENTRYPOINT ["java","-jar","/ensyu-end.jar"]

EXPOSE 8080