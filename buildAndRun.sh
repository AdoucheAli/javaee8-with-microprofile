#!/bin/sh
mvn clean package && docker build -t aliAdouche/javaee8-with-microprofile .
docker rm -f javaee8-with-microprofile || true && docker run -d -p 8080:8080 -p 4848:4848 --name javaee8-with-microprofile aliAdouche/javaee8-with-microprofile
