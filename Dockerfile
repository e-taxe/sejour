## get Dependace
FROM openjdk:8-alpine
### expose the url to exterieur
EXPOSE 8080
### ADD JAR
ADD target/taxe-sejour.jar app.jar
### Run Jar
CMD ["java","-jar","/app.jar"]