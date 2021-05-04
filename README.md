# Frontend-demo Application

This is a Spring boot application to test the communication of the pods inside a kubernetes cluster.

The controller provides a REST-API endpoints at **localhost:8080/**. 
It calls a service method `decorateGreeting()` which uses WebClient to send a get request to another Spring Boot 
app called "backend-demo".

![sequenceDiagram](/doc/diagrams/sequenceDiagram.png)