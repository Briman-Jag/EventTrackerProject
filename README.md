## EventTrackerProject (Part 1)
### Overview
My Event Tracker Project is used to keep track of Music Festivals attended, details about the event (genre of music, ticket price, headlining acts, dates, number of days, location), and list the musical artists I saw there. The program allows users to create, read, update, and delete Music Festival events from a database. It also allows users to make queries to find a list of festival by number of days, keywords in the festivals name, search by the headliner or genre, and find a list of festivals whose ticket prices are in a specific range.
### Description
(Part 1)
The project consists of a single table created in MySQL workbench.

<img src="MusicFestivalTable.png" width="300">
The table was then populated with data and a Web Application was created using Spring Boot with the goal of publishing a REST API, using Spring Data JPA to give full CRUD functions on the MusicFestivalTable, and have all that be tested using Postman.
The test conditions for the project were:

  * A new event object implements full CRUD.  
  * All interactions with the database are done so RESTfully.

(Part 2)
The second part of the project involved adding scripts with the use of Javascript to parse responses for full CRUD functionality. The music festival information is displayed with dynamically generated tables built in Javascript.

(Part 3)
The third part of this project was to develop the frontend of the Event Tracker application using AngularJS. Angular components, services, and directives were configured to send and receive JSON asynchronous requests to the Java controller with http. Bootstrap was also installed and applied to provide a more visually pleasing user interface.

### Routes
  | Return Type          | Route                  | Functionality                                                                       |
  |----------------------|------------------------|-------------------------------------------------------------------------------------|
  | `List<MusicFestival>`|`GET api/musicfestivals`                                | Gets all music festivals                            |
  | `List<MusicFestival>`|`GET api/musicfestivals/{musicFestId}`                  | Gets a music festival by id                         |
  | `List<MusicFestival>`|`POST api/musicfestivals`                               | Creates a new music festivals                       |
  | `List<MusicFestival>`|`PUT api/musicfestivals/{musicFestId}`                  | Updates details for an existing music festival by id|
  | `Boolean`            |`DELETE api/musicfestivals/{musicFestId}`               | Replaces an existing music festival  by id          |
  | `List<MusicFestival>`|`GET api/musicfestivals/search/{keyword}`               | Finds music festivals by keyword in its name        |
  | `List<MusicFestival>`|`GET api/musicfestivals/searchByGenre/{genre}`          | Finds music festivals by genre                      |
  | `List<MusicFestival>`|`GET api/musicfestivals/search/price/{low}/{high}`      | Finds music festivals with tickets priced in range  |
  | `List<MusicFestival>`|`GET api/musicfestivals/searchByDays/{numOfDays}`       | Finds music festivals by number of days             |
  | `List<MusicFestival>`|`GET api/musicfestivals/searchByHeadliners/{headliners}`| Finds music festivals by headlining acts            |

### Technologies Used

* Java
* JUnit
* POJO
* Postman
* REST API
* HTTP
* CRUD
* Spring Boot
* Spring Data JPA
* JPA
* MySQL Workbench
* Git/ GitHub
* MAMP
* Gradle
* AWS EC2
* Apache Tomcat
* AngularJS
* Components
* Services
* Directives
* DOM
* Visual Studio Code
* JSON
* SpringRest
* Javascript
* XMLHttpRequest


### Lessons Learned
A major issue that I ran into while doing this project was the spring boot application not being able to read my tables name correctly. The table was named MusicFestival and the application was looking for music_festival and giving an error that the table did not exist. To overcome this issue I added "spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl" to the applications.properties.
