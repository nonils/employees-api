FROM openjdk:8-jdk-alpine
MAINTAINER seebogado@gmail.com
VOLUME /tmp
EXPOSE 8080
ADD build/libs/employeeapi-0.0.1-SNAPSHOT.jar employee.jar
ENTRYPOINT ["java","-Dspring.profiles.active=docker","-Djava.security.egd=file:/dev/./urandom","-jar","/employee.jar"]
