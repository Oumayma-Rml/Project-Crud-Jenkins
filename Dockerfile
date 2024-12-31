
# Use the official Tomcat image as the base
FROM tomcat:9.0-jdk17

# Set the working directory inside the container
WORKDIR /usr/local/tomcat/webapps/

# Copy the WAR file into the Tomcat webapps directory
COPY target/Crud-0.0.1-SNAPSHOT.war Crud-0.0.1-SNAPSHOT.war

# Expose the default Tomcat port
EXPOSE 8080

# Start the Tomcat server
CMD ["catalina.sh", "run"]
