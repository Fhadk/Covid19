# Covid-19 Spring Boot Security

# Architecture

Spring Boot is a module of the Spring Framework. It is used to create stand-alone, production-grade Spring Based Applications with minimum efforts. It is developed on top of the core Spring Framework.Spring Boot follows a layered architecture in which each layer communicates with the layer directly below or above (hierarchical structure) it. Before understanding the Spring Boot Architecture, we must know the different layers and classes present in it. There are four layers in Spring Boot are as follows:

     Presentation Layer
     Business Layer
     Persistence Layer
     Database Layer

# Authentication / JWT Token

First, you need to get JWT token by calling /authenticate REST interface. It is POST method so set(using POSTMAN to get token):
    Header: Content-type = application/json
    Body: 
    {
      "username" : "foo",
      "password" : "foo"
    }

# REST intefaces

Secondly, To call rest interface we have to set:

    Header: Content-type = application/json
            Authorization: Bearer "JWT Token" 

To get list of users currently accessing the api /getActiveUser
All new cases reported today  /getNewCases
All new cases reported today country wise (sorted by cases reported today descending) /getNewCasesCountrySort 
All new cases reported today in a country /getNewCasesCountry
All new cases reported since a date in a country (choose whatever format but explain that in readme file) /getNewCasesCountryDate/{date} // format "mm-DD-yy"
Top N countries with most reported cases today /getNewCasesCountry/{count} 


# DockerFile

Docker file is included in .zip folder(not image file as its not requried disuccsed with concern person from your team)

# Spring Boot Test





