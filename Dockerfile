FROM maven:3.6.3-jdk-11 AS build
COPY src appQuiz/src
COPY pom.xml appQuiz
ARG jarName="appQuiz.jar"
RUN mvn -f appQuiz/pom.xml clean package

FROM openjdk:11
COPY --from=build appQuiz/target/QuizApp-0.0.1-SNAPSHOT.jar jarName
ENTRYPOINT ["java","-jar","jarName"]