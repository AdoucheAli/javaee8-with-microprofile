# Run

./buildAndComposeUp.sh

# Metrics

http://localhost:8080/metrics

curl -H'Accept:application/json' -i http://localhost:8080/metrics

# Health check

http://localhost:8080/health

# Open API

http://localhost:8080/openapi

# Docker commands


## Images

docker images -a

### Dangling images (images without name)

docker images -f "dangling=true"

### ID's

docker images -q

### Remove all images

docker rmi $(docker images -aq)

### Remove specific image

docker rmi adoucheali/javaee8-with-microprofile

### Remove dangling image

docker rmi $(docker images -q -f "dangling=true")

## Compose

### Create containers

docker-compse up

docker-compse up --build (to rebuild image)

### Stop containers

docker-compose down

## Containers

### All

docker ps -a

### Running

docker ps

### Remove all

docker rm $(docker ps -aq)

### Remove with filter

docker rm $(docker ps -f status=exited -aq)

### Remove specific

docker rm javaee8-with-microprofile

### Bash

docker exec -ti javaee8-with-microprofile bash

## Logs

docker logs javaee8-with-microprofile --follow


