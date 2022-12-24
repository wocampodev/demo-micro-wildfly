# Deploy on Kubernetes
Guide to help to deploy in Microk8s

```
# Build image with app
./mvnw clean package k8s:build

# Prepare image to registry in Microk8s
docker tag ubuntu:8080/demo-micro-wildfly localhost:32000/demo-micro-wildfly

# Registry image in Microk8s
docker push localhost:32000/demo-micro-wildfly

# Execute manifest for plan deployment app
microk8s kubectl apply -f microk8s.yml -n sandbox

# Access on browser
http://localhost/demo-micro-wildfly/todos

```