FROM ubuntu

WORKDIR .
COPY . /app
RUN apt -qq update && apt -qq -y install maven

CMD ["java -jar app/out/artifacts/OrientDB_jar/OrientDB.jar"]