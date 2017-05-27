FROM centos:7
MAINTAINER M.Hamady mohamed.ouldhamady@gmail.com

ENV container docker
ENV xterm=xterm-256

RUN yum -y upgrade && \
    yum -y install epel-release && \
    yum -y install wget tar gcc make file python-pip python-devel libffi-devel git && \
    pip install --upgrade pip && \
    yum clean all

RUN (cd /lib/systemd/system/sysinit.target.wants/; for i in *; do [ $i == \
systemd-tmpfiles-setup.service ] || rm -f $i; done); \
rm -f /lib/systemd/system/multi-user.target.wants/*;\
rm -f /etc/systemd/system/*.wants/*;\
rm -f /lib/systemd/system/local-fs.target.wants/*; \
rm -f /lib/systemd/system/sockets.target.wants/*udev*; \
rm -f /lib/systemd/system/sockets.target.wants/*initctl*; \
rm -f /lib/systemd/system/basic.target.wants/*;\
rm -f /lib/systemd/system/anaconda.target.wants/*;

VOLUME [ "/sys/fs/cgroup" , "/tmp", "/run", "/run/lock"]

CMD ["/usr/sbin/init"]
