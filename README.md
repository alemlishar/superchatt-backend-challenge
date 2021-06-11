# superchatt-backend-challenge
jdk 1.6
maven
Docker
Springboot
Hibernate

Running the program

step1(packaging) optional

firstly we nned to be in root folder and execute 

 mvn clean package -Dmaven.test.skip=true

this create superchat-backend-challenge-0.0.1.jar 

step 2
inside src/main/docker folder there is dockerfile, 

docker.txt
[FROM adoptopenjdk:16-jre-hotspot
EXPOSE 8089
ARG JAR_FILE=*.jar
LABEL maintainer="alextopten03@gmail.com"
COPY ${JAR_FILE} application.jar
ENTRYPOINT ["java", "-jar", "application.jar"] ]

docker build -t application .

this command execute superchat-backend-challenge-0.0.1.jar and build a docker image from the dockerfile


now lets containeraized and run the service for both the application and postgers database





execute thefollowing command to run the superchat-backend-challenge

docker run -d -p 8089:8089 --name application --link localpostgres:postgres application
docker run -d -p 5432:5432 --name localpostgres -e POSTGRES_PASSWORD=postgres postgres:12.7

