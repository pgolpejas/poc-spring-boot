FROM eclipse-temurin:17-jre-alpine
ARG VERSION
ARG JAR_FILE=poc-spring-boot-$VERSION.jar

ADD ${JAR_FILE} poc-spring-boot.jar

EXPOSE 8080 8081 9999
ENTRYPOINT java -jar poc-spring-boot.jar
