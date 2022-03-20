#FROM airhacks/payara:latest
FROM payara/server-full
COPY ./deployment-volume/javaee8-with-microprofile.war ${DEPLOYMENT_DIR}