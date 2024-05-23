# sukunaJava

### maven spring initalizr
nano ~/.zshrc
export MAVEN_HOME=/usr/local/maven/apache-maven-3.9.6
export PATH=$MAVEN_HOME/bin:$PATH
source ~/.zshrc

### create dirs .sh
chmod +x create_directories.sh
./create_directories.sh


### mvn clean install  
- (compile /target)
- artifect -> jar ~/.m2/repository
- 
### vs. reload maven project 
- intellj reload pom 
- download dep, rebuild paths


### spring cloud config server
- dynamic config server

### (mysql) (redis) docker-compose up -d
- -detach run in background

### mysql redis dockerize
- restart
- SSL=false ? **online resource worked**
- Sukuna % docker network inspect sukuna_network


### build eureka 
- ./mvnw clean package
- docker build -t my-eureka-server .
- docker push a1a4a7/my-eureka-server:latest

### JWT login
- auth -> db-service -> eureka -> db -> cache
- (tbd)gateway -> frontend

### enter mysql-docker
- docker exec -it mysql-container mysql -u your_username -p


### auth JWT + sessionCookie
- spring security
### dump containers
docker-compose down -v

### enter kafka log
- docker exec -it kafka /bin/bash
- cd /var/lib/kafka/logs
- ls -l




# TODOs
- [x] eureka access url | load balancer
- [x] api gateway
- [x] message queue
  - [] use case - db / redis- frontned
- [] k8s - lb(ingress)
- [] testing
- [] AWS


# improvements
- [] session cookie
- [] enforce api gateway access only
- [] workflow
  - [x] /auth -> return jwt
  - [] order / payment -> Kafka <- MsgQ Server
    - -> DB service -> redis /db
  - 