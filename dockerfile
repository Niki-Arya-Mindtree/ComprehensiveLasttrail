FROM maven:latest
COPY . .
COPY /target/Comprehensive-1.jar app.jar
CMD java -jar app.jar