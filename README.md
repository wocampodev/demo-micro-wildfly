# POC Microservice Wildfly
Demo for create microservices using Java 17 and JakartaEE 10 inside WIldfly Bootable JAR

# Hot Reload for Development
```
./run_mysql_8.sh
./run_app_dev.sh
```

# Launch App from JAR
```
./run_app_from_jar.sh
```

# Tests
```
curl -H "Content-Type: application/json" -d '{"title": "PI Planning 14","description": "Go to Lima"}' -X POST http://localhost:8080/todos
curl -H "Content-Type: application/json" -d '{"title": "PI Planning 14","description": "i"}' -X PUT http://localhost:8080/todos/1
curl -X GET http://localhost:8080/todos
curl -X GET http://localhost:8080/todos/1
curl -X DELETE http://localhost:8080/todos/1
```
