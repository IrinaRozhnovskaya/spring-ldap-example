# spring-ldap-example

The goal of this sample is to play with [`Spring Boot`](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/) REST API using `Spring Security LDAP`.

## Start docker-compose containers

  ```
  docker-compose up -d
  ```
## Run application

  ```
  ./mvnw clean spring-boot:run
  ```

## Testing 

   ```
   curl -i localhost:8080/api/public
   HTTP/1.1 200
   Welcome to the public page!
   ```
   ```
   curl -i localhost:8080/api/private
   HTTP/1.1 401
      {
        "timestamp": "2021-04-04T15:55:52.461+00:00",
        "status": 401,
        "error": "Unauthorized",
        "message": "Unauthorized",
        "path": "/api/private"
      }
   ```
   ``` 
   curl -i -u user:password localhost:8080/api/private
   HTTP/1.1 200
   user, welcome to the private page!
   ```

## Cleanup

- To stop app running press `Ctrl+C`

- To stop and remove docker-compose containers, networks and volumes run

  ```
  docker-compose down -v
  ```

## Reference Documentation

- [`Docker OpenLDAP`](https://github.com/osixia/docker-openldap/)
- [`LDAP server administration with phpLDAPadmin`](https://github.com/osixia/docker-phpLDAPadmin/)
- [`LDAP with Spring Security`](https://docs.spring.io/spring-security/site/docs/3.0.x/reference/ldap.html) 
