FROM ubuntu

WORKDIR /app
COPY . /app
RUN apt -qq update && apt -qq -y install maven

CMD ["/app/src/main/java/main.java"]