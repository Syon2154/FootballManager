# SimpleFootballManagerApplication

## Description
Solution for test task Football Manager

## Features
- Adding new football team (`POST: /teams`)
- Viewing all teams (`GET: /teams`)
- Viewing team by id (`GET: /teams/{id}`)
- Updating team (`PUT: /teams/{id}`)
- Deleting team (`DELETE: /teams/{id}`)

-----

- Adding new player (`POST: /players`)
- Viewing all players (`GET: /players`)
- Viewing player by id (`GET: /players/{id}`)
- Updating player information (`PUT: /player/{id}`)
- Deleting player (`DELETE: /player/{id}`)

-----

- Creating new transfer (`POST: /transfers`)
- Viewing all transfers (`GET: /transfers`)
- Viewing transfer by id (`GET: /transfers/{id}`)

## Technologies used
- Java 11
- Spring Boot
- Spring Data JPA
- H2 Database

## How to run project
1. Download and install Java 11 SDK.
2. Add your username and password in `application.properties` file.
3. Use Postman to send requests.
4. To run application in one command:
   - Open terminal or cmd
   - Go to directory with project
   - Run javac FootballManagerApplication.java to compile project, 
     then java FootballManagerApplication
   
-----

In the `resources` folder you can find `FootballManager.postman_collection.json`, 
import it into your Postman Workspace. This collection contains all necessary request to test 
application. You also can use `/inject` endpoint to fill database with test objects.
