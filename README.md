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