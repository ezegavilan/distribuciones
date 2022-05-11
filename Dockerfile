FROM adoptopenjdk:11-jre-hotspot
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} distribuciones-apirest.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/distribuciones-apirest.jar"]
