FROM java:8

EXPOSE 8080

ADD /target/shortenedurl-0.0.1-SNAPSHOT.jar shortenedurl-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "shortenedurl-0.0.1-SNAPSHOT.jar"]