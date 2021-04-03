# spring-ldap-example

The goal of this sample is to play with [`Spring Boot`](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/) REST API using `Spring Security LDAP`.

## Start docker-compose containers

  ```
  docker-compose up -d
  ```

## Import OpenLDAP users 

There are two ways to import users

### using phpldapadmin

- Go to https://localhost:6443

- Login with the following credentials

  ```
  Login DN: cn=admin,dc=my-company,dc=com
  Password: Admin123
  ```

- Import the file `spring-ldap-example/ldap/test-data.ldif`

### or running script

  ```
  cd ldap
  ./import-openldap-users.sh
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
