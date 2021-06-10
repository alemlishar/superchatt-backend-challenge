FROM adoptopenjdk:16-jre-hotspot
EXPOSE 8089
ARG JAR_FILE=*.jar
LABEL maintainer="alextopten03@gmail.com"
COPY ${JAR_FILE} application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]