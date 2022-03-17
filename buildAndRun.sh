#!/bin/sh
mvn clean package \
  && docker build -t adoucheali/javaee8-with-microprofile:latest . \
  && docker rm -f javaee8-with-microprofile || true \
  && docker run -d -p 8080:8080 -p 4848:4848 --name javaee8-with-microprofile adoucheali/javaee8-with-microprofile:latest
