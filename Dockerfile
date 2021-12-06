## get Dependace
FROM openjdk:8-jdk-alpine
### expose the url to exterieur
EXPOSE 8080
### ADD JAR
ADD target /taxe-sejour.jar
### Run Jar
CMD ["java","-jar","/taxe-sejour.jar"]