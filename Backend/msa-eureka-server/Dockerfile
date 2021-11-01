FROM openjdk:16-jdk-slim@sha256:77a90136a7a3bd2342adc2a4e10815a5bd71598fa2c8b5906c284dfd24e10ccc
RUN mkdir /app
RUN addgroup javauser && adduser --ingroup javauser --disabled-password --gecos '' javauser
COPY /target/portal-eureka-server.jar /app/portal-eureka-server.jar
WORKDIR /app
RUN chown -R javauser:javauser /app
USER javauser
CMD "java" "-jar" "portal-eureka-server.jar"
