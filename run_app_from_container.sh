#!/bin/sh

IP_LOCAL="192.168.136.132"

export MYSQL_USER=admin
export MYSQL_PASSWORD=admin
export MYSQL_DATABASE=demo-micro-wildfly
export MYSQL_URL="jdbc:mysql://${IP_LOCAL}:3306/demo-micro-wildfly"

docker stop mysql-demo-micro-wildfly

docker run -d --rm \
	--name mysql-demo-micro-wildfly -p 3306:3306 \
	-e MYSQL_USER=${MYSQL_USER} \
	-e MYSQL_PASSWORD=${MYSQL_PASSWORD} \
	-e MYSQL_ROOT_PASSWORD=root \
	-e MYSQL_DATABASE=${MYSQL_DATABASE} \
	mysql:8

./mvnw clean package k8s:build

docker stop demo-micro-wildfly

docker run -d --rm \
	--name demo-micro-wildfly -p 8080:8080 \
	-e MYSQL_USER=${MYSQL_USER} \
  	-e MYSQL_PASSWORD=${MYSQL_PASSWORD} \
  	-e MYSQL_DATABASE=${MYSQL_DATABASE} \
  	-e MYSQL_URL=${MYSQL_URL} \
	ubuntu:8080/demo-micro-wildfly:latest
