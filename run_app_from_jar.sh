#!/bin/sh

IP_LOCAL="192.168.136.132"

export MYSQL_USER=admin
export MYSQL_PASSWORD=admin
export MYSQL_DATABASE=demo-micro-wildfly
export MYSQL_URL="jdbc:mysql://${IP_LOCAL}:3306/demo-micro-wildfly"

./mvnw clean package
java -jar target/demo-micro-wildfly-bootable.jar
