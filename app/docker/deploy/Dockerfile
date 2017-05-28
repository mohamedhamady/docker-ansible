FROM local/java
MAINTAINER M.Hamady mohamed.ouldhamady@gmail.com

COPY target/vertx-guice-fat.jar /build/

COPY docker/deploy/vertx_guice.service /etc/systemd/system/
RUN systemctl enable vertx_guice.service

EXPOSE 8080 9200

CMD ["/usr/sbin/init"]

LABEL application=vertx-guice