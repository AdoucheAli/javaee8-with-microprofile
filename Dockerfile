#FROM payara/server-full
FROM airhacks/payara:latest
COPY ./target/javaee8-with-microprofile.war ${DEPLOYMENT_DIR}
