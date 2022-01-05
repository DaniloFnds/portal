FROM openjdk:16-jdk-slim@sha256:77a90136a7a3bd2342adc2a4e10815a5bd71598fa2c8b5906c284dfd24e10ccc
RUN mkdir /app
RUN addgroup javauser && adduser --ingroup javauser --disabled-password --gecos '' javauser
COPY /target/portal-config-server.jar /app/portal-config-server.jar
ENV EUREKA_SERVER=http://dhan.com.br:9000/eureka
WORKDIR /app
RUN chown -R javauser:javauser /app
USER javauser
CMD "java" "-jar" "portal-config-server.jar"


#
# FROM openjdk:16-jdk-slim@sha256:77a90136a7a3bd2342adc2a4e10815a5bd71598fa2c8b5906c284dfd24e10ccc
# WORKDIR application
#
# RUN addgroup javauser && adduser --ingroup javauser --disabled-password --gecos '' javauser
# USER demo
#
# COPY mvnw .
# COPY .mvn .mvn
# COPY pom.xml .
# COPY src src
#
# RUN --mount=type=cache,target=/mnt/c/Users/Danilo/.m2 ./mvnw  install -DskipTests
#
# RUN cp /application/target/*.jar app.jar
# RUN java -Djarmode=layertools -jar app.jar extract
#
# FROM openjdk:16-jdk-slim@sha256:77a90136a7a3bd2342adc2a4e10815a5bd71598fa2c8b5906c284dfd24e10ccc
# WORKDIR application
# COPY --from=bulid application/dependencies/ ./
# COPY --from=bulid application/spring-boot-loader/ ./
# COPY --from=bulid application/snapshot-dependencies/ ./
# COPY --from=bulid application/application/ ./
# ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
