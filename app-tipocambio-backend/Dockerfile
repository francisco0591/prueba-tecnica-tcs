FROM openjdk:21-jdk
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app-tipocambio-backend-0.0.1.jar
ENTRYPOINT ["java","-jar","/app-tipocambio-backend-0.0.1.jar"]