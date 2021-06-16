superchatt-backend-challenge

# Technology stack

     .jdk 1.16
     .maven
     .Docker version 20
     .Springboot version 3.77
     .Hibernate
     .Postgresql 12.7

 -- Running the program

 ## Step1[optional, packaging jar , the jar already existed in /target/superchat-backend-challenge-0.0.1.jar] optional

        firstly we nned to be in root folder and execute 

   mvn clean package -Dmaven.test.skip=true

        this create superchat-backend-challenge-0.0.1.jar 

 # Step2 [important, crerate a docker image using the dockerfile in -src/main-/docker/dockerfile]
 
        inside src/main/docker folder there is dockerfile, 

               docker.txt
               [FROM adoptopenjdk:16-jre-hotspot
               EXPOSE 8089
               ARG JAR_FILE=*.jar
               LABEL maintainer="alextopten03@gmail.com"
               COPY ${JAR_FILE} application.jar
               ENTRYPOINT ["java", "-jar", "application.jar"] ] .
        this command execute superchat-backend-challenge-0.0.1.jar and build a docker image from the dockerfile
   
   docker build -t application
         
 # Step2.5[Very important,  DATABASE]
 
        we dont have up working database, lets build from docker image and run the database
         
   docker run -d -p 5432:5432 --name localpostgres -e POSTGRES_PASSWORD=postgres postgres:12.7
             
              -d : run it in detached mode,
              --name : container a name (localpostgres) , to be used in step 3
               postgres:12.7 : is the version to be run when the container upon
                     
          Lets create the databse and finish the step
          create databse postgres
          
 # Step3[very important, running the service and database as a docker image]
 
        now lets containeraized and run the service for both the application and postgers database
      
   docker run -d -p 8089:8089 --name application --link localpostgres:postgres application
   docker run -d -p 5432:5432 --name localpostgres -e POSTGRES_PASSWORD=postgres postgres:12.7
   
        we created and run this two container
          
                localpostgres: on port 5432  postgresl databse
                application:   on port 8089  superchat-Backend-Challenge rest api 


# Done!!!



