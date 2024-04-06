# Use the official Java image as the base image
FROM maven:3.8.5-openjdk-17 AS Bhavani 
# Copy the source code into the container
Copy . .
 
# Build the Java application using Maven
RUN mvn clean compile package
 
 
From openjdk:17.0.1-jdk-slim
# Copy the WAR file to the Tomcat webapps directory
COPY --from=Bhavani /target/student_management_system-0.0.1-SNAPSHOT.jar student_management_system-0.0.1-SNAPSHOT.jar
 
# Expose port 8080
EXPOSE 8080
 

ENTRYPOINT [ "java","-jar","student_management_system-0.0.1-SNAPSHOT.jar" ]

