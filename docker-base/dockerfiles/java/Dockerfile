FROM local/c7-systemd
MAINTAINER M.Hamady mohamed.ouldhamady@gmail.com

ENV JAVA_HOME /opt/jdk8
ENV MAVEN_HOME /opt/maven


RUN mkdir /opt/packages 

COPY jdk-8u111-linux-x64.tar.gz /opt/packages/
COPY apache-maven-3.5.0-bin.tar.gz /opt/packages/
COPY install-java.sh /opt/packages/
COPY install-maven.sh /opt/packages/

RUN chmod +x /opt/packages/install-java.sh && \
    chmod +x /opt/packages/install-maven.sh && \
    /opt/packages/install-java.sh && \
    /opt/packages/install-maven.sh
