FROM osixia/openldap-backup:1.5.0
LABEL maintainer="Irina Rozhnovskaya <irina.rozhnovskay@gmail.com> https://github.com/IrinaRozhnovskaya/spring-ldap-example"
ENTRYPOINT ["/bin/bash"]
CMD ["-c", "/container/tool/run --copy-service -l debug"]
COPY --chown=openldap:openldap ./test-data.ldif /container/service/slapd/assets/config/bootstrap/ldif/50-test-data.ldif
