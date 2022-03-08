# Build
mvn clean package && docker build -t org.example/javaee8-with-microprofile .

# RUN

docker rm -f javaee8-with-microprofile || true && docker run -d -p 8080:8080 -p 4848:4848 --name javaee8-with-microprofile org.example/javaee8-with-microprofile 