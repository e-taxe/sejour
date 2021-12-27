FROM openjdk:8-alpine
COPY target/*.jar app.jar
EXPOSE 8090
CMD ["java","-jar","app.jar"]