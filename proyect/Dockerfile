FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} tingeso.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/tingeso.jar"]