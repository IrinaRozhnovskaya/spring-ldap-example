#!/usr/bin/env bash

ldapadd -x -D "cn=admin,dc=my-company,dc=com" -w Admin123 -H ldap:// -f test-data.ldif
