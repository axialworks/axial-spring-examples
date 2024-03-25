
# Add Maven Wrapper:
# mvn -N wrapper:wrapper -Dmaven=3.5.2

# https://docs.docker.com/language/java/build-images/

# Docker build Image:
# docker build -t examples-app .

# docker tag examples-app:latest examples-app:1.0

# Docker export and save image:
# docker save examples- app:latest > examples-app.tar

##############################################################
###### Working Example - Spring Boot Run ######

# Import Maven
# FROM eclipse-temurin:17-jdk-jammy

# WORKDIR /app

# COPY .mvn/ .mvn
# COPY mvnw pom.xml ./

# RUN ./mvnw dependency:resolve

# COPY src ./src

# EXPOSE 8050

# CMD ["./mvnw", "spring-boot:run"]

##############################################################
###### Working Example - Tomcat Deploy ######

# Use an official Tomcat image as the runtime environment
FROM tomcat:10.1.17-jdk17-temurin-jammy AS tomcat-deploy-stage

# Set the working directory in the container
WORKDIR /usr/local/tomcat/webapps

# Copy the WAR file into Tomcat directory - If dockerignore file exists /target path discarded!!!!!!
COPY target/spring-boot-examples-1.0.war ./examples.war

# Run Tomcat
CMD ["catalina.sh", "run"]

##############################################################
###### Working Example - Maven Build + Tomcat Deploy ######

# Import Maven and JDK
# FROM maven:3.9.6-amazoncorretto-17 AS java-build-stage

# Set the working directory in the container for Maven Build
# WORKDIR /app/files

# Copy project files from local pc into container working directory
# COPY ./ .

# Package java project and create project with Maven
# RUN mvn clean package

# WORKDIR /app

# RUN cp files/target/spring-boot-examples-1.0.war examples.war

# RUN rm -r files

# Use an official Tomcat image as the runtime environment
# FROM tomcat:10.1.17-jdk17-temurin-jammy AS tomcat-deploy-stage

# Set the working directory in the container
# WORKDIR /usr/local/tomcat/webapps

# Copy the WAR file into Tomcat directory
# COPY --from=java-build-stage /app/examples.war .

# EXPOSE 8050

# Run Tomcat
# CMD ["catalina.sh", "run"]

##############################################################

