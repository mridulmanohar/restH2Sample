# rest-H2 Example

A complete REST Server application created with Spring Boot 2.1.2 and Jersey 2.27
uses hibernate 5.3.7 to interact with underlying H2 database

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.
See deployment for notes on how to deploy the project on a live system.


## Running the tests

Following tests can be invoked using a Rest Client like Postman --

GET - http://localhost:8080/emp/1101
POST - localhost:8080/emp/create/emp
PUT - localhost:8080/emp/update/emp
DEL - localhost:8080/emp/delete/1

## Deployment

Run com.jaxrs.poc.RestH2SampleApplication.class
H2 Console can be viewed at --  http://localhost:8080/h2-console/

## Technologies used/Built With

* [Spring](https://spring.io/projects/spring-boot) - The Spring framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [Jersey](https://jersey.github.io/) - the JAX-RS Reference Implementation
* [Hibernate](https://hibernate.org/orm/documentation/5.0/) - ORM for JPA 2.2 specification

## Authors

* **Mridul Manohar** - [mridul](https://github.com/mridulmanohar)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc

