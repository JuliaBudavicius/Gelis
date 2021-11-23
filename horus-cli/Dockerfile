FROM openjdk:11
RUN mkdir /etc/test/
RUN chmod 777 /etc/test/
COPY horus-cli-1.0-SNAPSHOT-jar-with-dependencies.jar /etc/test/
WORKDIR /etc/test/
ENTRYPOINT [ "java", "-jar", "horus-cli-1.0-SNAPSHOT-jar-with-dependencies.jar" ]