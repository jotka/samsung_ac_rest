FROM openjdk:11.0.7-jre-slim
MAINTAINER jkrochmalski@gmail.com
COPY target/ac-rest-1.0.0.jar ac-rest-1.0.0.jar
ENTRYPOINT ["java","-jar","/ac-rest-1.0.0.jar"]