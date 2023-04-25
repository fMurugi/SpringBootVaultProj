# Vault with Spring boot

Vault is for storing credentials

## Run a Vault instance using docker-compose

Create  docker-compose.yml file at the root of your project and add the following
```bash
 # docker_compose.yml
version: '2'
services:
    myvault:
        image: vault
        container_name: myvault
        ports:
          - "8201:8200"
        volumes:
          - ./file:/vault/file:rw
          - ./config:/vault/config:rw
        cap_add:
          - IPC_LOCK
        entrypoint: vault server -config=/vault/config/vault.json

```

## Add the following in config/vault.json

```java
{
    "backend": {"file": {"path": "/vault/file"}},
    "listener": {"tcp": {"address": "0.0.0.0:8200", "tls_disable": 1}},
    "default_lease_ttl": "168h",
    "max_lease_ttl": "0h"
  }
```

## Execute the docker-compose file

````
docker-compose up
````
## NB Take note of the token generated 
## All the below should be done inside the running container
execute the container like below
````
# check the id of the container
docker ps
# execute the container
docker exec -u <user> -it <container  id>  sh
````
Check if the Vault is sealed  or not .if sealed ,unseal it using the keys
vault status  to check if vault is sealed 
````
vault status
vault operator init  to get the keys to unseal the vault
vault operator unseal <key>

````
## Store your credentials in the container
  vault kv put -mount=secret techgeeknextApp dbusername=username dbpassword=password

if no permission  granted for the token used :
## set up the policies using the vault documentation below

https://developer.hashicorp.com/vault/tutorials/policies/policies
## Also checkout this helpful resource incase you are stuck

https://github.com/hashicorp/vault/issues/6616

#### now set u your pom.xml
````
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
<groupId>org.springframework.cloud</groupId>
<artifactId>spring-cloud-starter-vault-config</artifactId>
</dependency>
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>
<dependency>
<groupId>mysql</groupId>
<artifactId>mysql-connector-java</artifactId>
<version>8.0.28</version>
<scope>runtime</scope>
</dependency>
<dependency>
<groupId>org.projectlombok</groupId>
<artifactId>lombok</artifactId>
<optional>true</optional>
</dependency>
````
#### set up the bootstrap.yml file
````
spring:
application:
name: <app name>
cloud:
vault:
host: localhost
port: 8201
scheme: http
token: <token>
````
## Add the following into you application.properties file
## Spring DATASOURCE
````
spring.datasource.url = jdbc:mysql://localhost:3306/db?createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false
spring.datasource.username=${dbusername}
spring.datasource.password=${dbpassword}
spring.datasource.platform=mysql
spring.datasource.initialization-mode=always

## Hibernate Propertie
# Hibernate ddl auto (create, create-drop, validate, update)
spring.jpa.database-platform = org.hibernate.dialect.MySQL5Dialect
spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto = update

server.port=port
````
## license
[MIT](https://choosealicense.com/licenses/mit/)
