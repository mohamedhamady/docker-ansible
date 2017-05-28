FROM local/java
MAINTAINER M.Hamady mohamed.ouldhamady@gmail.com

COPY docker/deploy/vertx_guice.service /etc/systemd/system/
RUN systemctl enable vertx_guice.service

COPY scripts/entrypoint.sh /usr/local/bin/entrypoint.sh
RUN chmod +x /usr/local/bin/entrypoint.sh

EXPOSE 8080 9200

ENTRYPOINT ["entrypoint.sh"]
CMD ["/usr/sbin/init"]

LABEL application=vertx-guice