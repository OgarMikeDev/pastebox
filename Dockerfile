FROM openjdk:17-jdk_alpine
MAINTAINER Mike Ogar
COPY \target\pastebox-0.0.1-SNAPSHOT.jar pastebox.jar
ENTRYPOINT ["java", "-jar", "\\pastebox.jar"]