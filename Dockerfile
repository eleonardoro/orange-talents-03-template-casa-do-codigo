FROM openjdk:11
LABEL Eleonardo Oliveira
COPY target/casa-do-codigo-v1.jar casa-do-codigo-v1.jar
ENTRYPOINT ["java","-jar","/casa-do-codigo-v1.jar"]