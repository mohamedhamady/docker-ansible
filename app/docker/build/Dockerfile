FROM local/java
MAINTAINER M.Hamady mohamed.ouldhamady@gmail.com

RUN mkdir /opt/app

COPY src /opt/app/src
COPY pom.xml /opt/app

COPY scripts/entrypoint.sh /usr/local/bin/entrypoint.sh
RUN chmod +x /usr/local/bin/entrypoint.sh

WORKDIR /opt/app

ENTRYPOINT ["entrypoint.sh"]
