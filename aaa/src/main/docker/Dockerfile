FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD eee*.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]