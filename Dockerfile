RUN ubuntu

WORKDIR /app
COPY . /app
RUN apt -qq install maven

CMD ["/app/src/main/java/main.java"]