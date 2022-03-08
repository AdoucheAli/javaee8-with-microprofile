FROM airhacks/payara5
COPY ./target/javaee8-with-microprofile.war ${DEPLOYMENT_DIR}
