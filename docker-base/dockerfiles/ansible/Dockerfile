FROM local/c7-systemd
MAINTAINER M.Hamady mohamed.ouldhamady@gmail.com

RUN yum -y install ansible

VOLUME /ansible
WORKDIR /ansible

ENTRYPOINT ["ansible-playbook"]
CMD ["site.yml"]