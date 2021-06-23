# project-registry-project-backend

## Project Description
This is a microservice representation of the Registry Backend. This microservice contains Controller and Service methods for Organization, Tag, and Project.

## Technologies Used
* Java 8
* Spring Boot
* Spring MVC
* Spring AOP
* Spring Data
* JUnit
* Mockito
* AWS S3
* PostgreSQL
* Jenkins

## Features
* Communicate with the Organization, Tag, and Project tables within a AWS S3 database.
* CRUD operations for Organization, Tag, and Project.
* Has API endpoints to connect to each service.

To-do List:
* Create separate database structure for this microservice.

## Usage
* This application serves as an API for the Registry frontend.
* Entering the base endpoints into a web browser will process a get request from the api. Returning a full list of the respective database entities. 
  - Organization endpoint: /api/organization
  - Project endpoint: /api/project
  - Tag endpoint: /api/tag
* Adding "/id/{id}" to a base endpoint retrieves a specific entity object by its id.
* Other API calls require execution from the front end or from a testing application like Postman.

# Running Locally
* git clone https://github.com/Project-Registry-991-Kevin-Tran-Huu/project-registry-project-microservice.git
* Run this project in Eclipse or SpringToolSuite
* Do a Maven update to import the dependencies needed from the pom.xml
* Launch a Consul instance from a Docker container on port 8500
* Launch this application using spring boot.
* This app will run at http://localhost:8082

# Docker Image
