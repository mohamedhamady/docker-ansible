FROM local/ansible
MAINTAINER M.Hamady mohamed.ouldhamady@gmail.com

COPY ansible /ansible

VOLUME /ansible

WORKDIR /ansible

ENTRYPOINT ["ansible-playbook"]
CMD ["site.yml"]