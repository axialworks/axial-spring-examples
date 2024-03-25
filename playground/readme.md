

### Add Maven Wrapper
```bash
mvn -N wrapper:wrapper -Dmaven=3.5.2
```

### create project package
```bash
mvn -f ../parent-pom/ clean install
mvn -f ../commons/ clean install
mvn -f ../openapi/ clean install
mvn clean package

cp target/examples-1.0.war target/examples.war
```


### deploy to local tomcat 10
```bash
export TOMCAT_PATH="C:/Program Files/Apache Software Foundation/Tomcat 10.1"

cp target/examples.war "$TOMCAT_PATH/webapps" 

export CATALINA_OPTS="${CATALINA_OPTS} -Dspring.datasource.app.url=jdbc:mariadb://bl-nas:3307/media_db -Dspring.datasource.app.username=nas_db_user -Dspring.datasource.app.password=BL-db.112358 -Dspring.datasource.app.driver-class-name=org.mariadb.jdbc.Driver -Dspring.datasource.test.url=jdbc:mariadb://selmankaya.com:3306/selmank1_test_db -Dspring.datasource.test.username=selmank1_app -Dspring.datasource.test.password=NM$8pS3o2lR7 -Dspring.datasource.test.driver-class-name=org.mariadb.jdbc.Driver"

cd "$TOMCAT_PATH/bin"

./catalina.bat stop
./catalina.bat start

#./shutdown.bat
#./startup.bat

ps aux | grep tomcat
```

### create docker image from source code
`Documentation` : <https://docs.docker.com/language/java/build-images/>

```bash
# Docker build Image:
docker build -t examples-app .

# add tag
docker tag examples-app:latest examples-app:1.0

# Docker export and save image:
docker save examples-app:1.0 > target/examples-app.tar
```

### Example kubectl commands 
```bash
kubectl get deployments -n demo-work

kubectl create -f deployment.yaml

kubectl delete deployment example-app -n demo-work
kubectl delete -f example-app -n demo-work

kubectl get pods --namespace demo-work
kubectl get pods -n demo-work
```

## Dockerfile Examples

<pre>
###### Working Example - Spring Boot Run ######

# Import Maven
FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

# COPY .mvn/ .mvn
COPY mvnw pom.xml ./

RUN ./mvnw dependency:resolve

COPY src ./src

EXPOSE 8050

CMD ["./mvnw", "spring-boot:run"]
</pre>

<pre>
###### Tomcat Deploy ######

# Use an official Tomcat image as the runtime environment
FROM tomcat:10.1.17-jdk17-temurin-jammy AS tomcat-deploy-stage

# Set the working directory in the container
WORKDIR /usr/local/tomcat/webapps

# Copy the WAR file into Tomcat directory - If dockerignore file exists /target path discarded!!!!!!
COPY target/examples-1.0.war ./examples.war

# Run Tomcat
CMD ["catalina.sh", "run"]
</pre>

<pre>
###### Maven Build + Tomcat Deploy ######

# Import Maven and JDK
FROM maven:3.9.6-amazoncorretto-17 AS java-build-stage

# Set the working directory in the container for Maven Build
WORKDIR /app/files

# Copy project files from local pc into container working directory
COPY ./ .

# Package java project and create project with Maven
RUN mvn clean package

WORKDIR /app

RUN cp files/target/examples-1.0.war examples.war

RUN rm -r files

# Use an official Tomcat image as the runtime environment
FROM tomcat:10.1.17-jdk17-temurin-jammy AS tomcat-deploy-stage

# Set the working directory in the container
WORKDIR /usr/local/tomcat/webapps

# Copy the WAR file into Tomcat directory
COPY --from=java-build-stage /app/examples.war .

# EXPOSE 8050

# Run Tomcat
CMD ["catalina.sh", "run"]
</pre>