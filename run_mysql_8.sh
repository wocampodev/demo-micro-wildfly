#!/bin/sh

docker run -d --rm \
	--name mysql-demo-micro-wildfly -p 3306:3306 \
	-e MYSQL_USER=admin \
	-e MYSQL_PASSWORD=admin \
	-e MYSQL_ROOT_PASSWORD=root \
	-e MYSQL_DATABASE=demo-micro-wildfly \
	mysql:8
