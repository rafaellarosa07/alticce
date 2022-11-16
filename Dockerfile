FROM adoptopenjdk/openjdk11:latest

ADD target/alticce-0.0.1-SNAPSHOT.jar alticce.jar

ENTRYPOINT ["java","-jar","alticce.jar"]