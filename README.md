# RASSUS-project
FER faculty project

Microservice for temperature and humidity measurements. 
Temperature and humidity values are retrieved from the file "mjerenja.csv" and saving in in-memory database H2.
Temperature-microservice and humidity-microservice retreive values from H2 database through REST API.
Aggregator is getting both values from temperature-microservice and humidity-microservice.
Microservices are using config-server for their configurations and eureka-server for 
registering and later searching for other microservices. Config directory contains docker-compose.yml.


- SPRING BOOT
- GRADLE
- REST
- MICROSERVICES
- SPRING CLOUD CONFIG
- NETFLIX EUREKA
- DOCKER
