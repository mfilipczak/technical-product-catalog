FROM java:8
VOLUME /tmp
ADD target/technical-product-catalog-0.1.0-exec.jar app.jar
EXPOSE 8181
ENV JAVA_OPTS=""
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar