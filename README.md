# Installation guide

## Software
The following programs need to be installed beforehand in order for this application to work. This guide is made while
keeping "Windows" users in mind who use the "localhost" on a computer. Pls keep this in mind while reading this guide.

- Server or localhost
- JDK
- MySql
- Postman
- IntelliJ IDEA
- Google Chrome


Server or localhost
There has to be a device set up where you are able to run the application and the database. This is the device where you
should install all the required software to run the application. You can run the application on your computer even if
there is not a server available. This installation guide is made for the "localhost".

JDK
JDK stands for Java Development Kit. With this software you wil be able to startup the java code. The "Java" code,
is the programming language that is applied to write the backend. Like an engine that is needed to start a car for
example. Once installed, this program will be used in IntelliJ IDEA.
Please find the installation instructions here: https://www.oracle.com/java/technologies/downloads/#java11-windows

MySql
This software is to be used to run the database of this application. A database is used to save information. Like when
a user is registered. the user information will be saved in the database. Once installed, pls search for an app called 
"pgAdmin". With this app you will be able to run the software in order run and access your database.
Please find the installation instructions here: https://dev.mysql.com/downloads/installer/

Postman
To simulate an API request you can use Postman. This can be done via the browser or a downloaded version. Postman is an 
application that is used as a tool to test the performance of an application that one is developing. Moreover, it is 
often used to test the performance of the API requests from the backend.
Please find the installation instructions here: https://www.guru99.com/postman-tutorial.html

IntelliJ IDEA
It is recommended to download this software in order to see the code of this application. The application is run via
this program Both the frontend, and the backend code is written in IntelliJ IDEA.  IntelliJ IDEA is software that is
used to write code for an application that one is developing. When opening the front end project, there are a two 
commands that you need to use. These are "npm install + npm start" commands need to be used. 

- Please click on the "terminal" at the bottom of the screen.
- Then type the command: npm install (This only needs to be done once).
- Then type the command: npm start (This needs to be done every time when starting up the frontend).

When opening the backend project please find and open the file called "application.properties".
Please make sure that the following values are the same. When the values are different, please change them as described
shown below:
spring.datasource.url= jdbc:postgresql://localhost:5432/sunshine
spring.datasource.username= postgres
spring.datasource.password= test
spring.datasource.initialization-mode=always

server.port=8080

This step only needs to be done once. Then click on the "run button" to start running the backend. It is a green icon on
top of the screen that looks like a "play button" shaped as a triangle. 
Please find the installation instructions here: https://www.jetbrains.com/idea/download/#section=windows

Google Chrome 
Chrome is an internet webbrowser which can be used to acces and surf the WWW (World Wide Web) also known as the internet.
Please find the installation instructions here: https://www.google.com/chrome/



## Rest endpoints

### Overview

|method|endpoint|token needed?|
|------|--------|-------------|
|GET|//api/user/{username}|yes|
|POST|/api/user/{id}/categories|yes|
|DELETE| /api/user/{id}/categories|yes|
|GET| /api/user/{id}/reservations|yes|
|GET| /api/categories|no|
|GET|/api/reservation/{id}|yes|
|PATCH|/api/reservation/{id}|yes|
|POST|/api/reservation|yes|
|POST|/api/auth/signin|no|
|POST|/api/auth/signup|no|


### GET /api/user/{username}
Retrieves 1 user by its username. For this endpoint a token is required. So you must be logged in to be authenticated.
In this example, the username is: lturnbull1.

Request:

- [x] Token required

body
none: This request does not have a body

Response:

body
```json
{
    "id": 2,
    "username": "lturnbull1",
    "firstname": "Lucienne",
    "lastname": "Turnbull",
    "email": "lturnbull1@hhs.gov",
    "phonenumber": "690 765 9844",
    "street": "Sutherland",
    "housenumber": "73",
    "postalcode": "8315YO",
    "provincie": "Zuid-Holland",
    "roles": [
        {
            "id": 2,
            "name": "ROLE_HANDYMAN"
        }
    ]
}
```
![GetUserByUsername](https://user-images.githubusercontent.com/66301166/147088816-20d88037-4d3d-46b8-a7cc-0f60deff9a83.png)

### POST /api/user/{id}/categories
A handyman can use this endpoint to update their service list. When a handyman expands their services they can be added 
by using this endpoint and clicking on the checkboxes of the corresponding service. The ID in the endpoint refers to a 
specific handyman. In this example, the ID is:2

Request:

- [x] Token required

body
```json
{
  "categoryId": "19"
}
```
Response:

body
```json
19
```

![Add Service](https://user-images.githubusercontent.com/66301166/147089374-4d370d02-f157-4dfb-a62d-7976a7ac181f.png)

### DELETE /api/user/{id}/categories 
A handyman can use this endpoint to delete services from their service list. When a handyman decides to stop offering a 
service, the handyman can update the service list by unchecking a checkbox of the corresponding service. The ID in the
endpoint refers to a specific handyman. In this example, the ID is:2

Request:

- [x] Token required

body
```json
{
  "categoryId": "19"
}
```
Response:

body
```json
19
```
![Delete Service](https://user-images.githubusercontent.com/66301166/147089669-47b0d1f8-2cf0-4c7a-a583-6d17ff3c6686.png)


### GET /api/user/{id}/reservations
With this endpoint a user can retrieve all of their personal reservations. 
The ID in the endpoint refers to a specific handyman. In this example, the ID is:2

Request:

- [x] Token required

body
none: This request does not have a body
Response:

body
```json
[
  {
    "id": 1,
    "reservationDate": "2021-11-24",
    "handyman": {
      "id": 2,
      "username": "lturnbull1",
      "firstname": "Lucienne",
      "lastname": "Turnbull",
      "email": "lturnbull1@hhs.gov",
      "phonenumber": "690 765 9844",
      "street": "Sutherland",
      "housenumber": "73",
      "postalcode": "8315YO",
      "provincie": "Zuid-Holland",
      "roles": [
        {
          "id": 2,
          "name": "ROLE_HANDYMAN"
        }
      ]
    },
    "category": {
      "id": 2,
      "name": "Painter",
      "price": "90",
      "jobDescription": "paint the walls and stuff",
      "handymen": [
        {
          "id": 2,
          "username": "lturnbull1",
          "firstname": "Lucienne",
          "lastname": "Turnbull",
          "email": "lturnbull1@hhs.gov",
          "phonenumber": "690 765 9844",
          "street": "Sutherland",
          "housenumber": "73",
          "postalcode": "8315YO",
          "provincie": "Zuid-Holland",
          "roles": [
            {
              "id": 2,
              "name": "ROLE_HANDYMAN"
            }
          ]
        },
        {
          "id": 4,
          "username": "mmagwood3",
          "firstname": "Mart",
          "lastname": "Magwood",
          "email": "mmagwood3@walmart.com",
          "phonenumber": "885 528 8118",
          "street": "Vahlen",
          "housenumber": "8",
          "postalcode": "3189PA",
          "provincie": "Vérane",
          "roles": [
            {
              "id": 2,
              "name": "ROLE_HANDYMAN"
            }
          ]
        }
      ]
    },
    "image": null
  },
  {
    "id": 11,
    "reservationDate": "2/14/2021",
    "handyman": {
      "id": 2,
      "username": "lturnbull1",
      "firstname": "Lucienne",
      "lastname": "Turnbull",
      "email": "lturnbull1@hhs.gov",
      "phonenumber": "690 765 9844",
      "street": "Sutherland",
      "housenumber": "73",
      "postalcode": "8315YO",
      "provincie": "Zuid-Holland",
      "roles": [
        {
          "id": 2,
          "name": "ROLE_HANDYMAN"
        }
      ]
    },
    "category": {
      "id": 19,
      "name": "Toilet repair",
      "price": "64",
      "jobDescription": "upward-trending",
      "handymen": []
    },
    "image": null
  }
]
```
![ReservationsByUserId](https://user-images.githubusercontent.com/66301166/147090596-27481cdd-c1ca-406e-8b49-cfb9d4a4a8e8.png)

### GET /api/categories
Retrieves all categories. Plus any associated handyman that is providing the service. 

Request:

- [ ] Token required

body
none: This request does not have a body

Response:

body
```json
[
    {
        "id": 1,
        "name": "Plumber",
        "price": "35",
        "jobDescription": "plumbing is for the pipes",
        "handymen": [
            {
                "id": 2,
                "username": "lturnbull1",
                "firstname": "Lucienne",
                "lastname": "Turnbull",
                "email": "lturnbull1@hhs.gov",
                "phonenumber": "690 765 9844",
                "street": "Sutherland",
                "housenumber": "73",
                "postalcode": "8315YO",
                "provincie": "Zuid-Holland",
                "roles": [
                    {
                        "id": 2,
                        "name": "ROLE_HANDYMAN"
                    }
                ]
            },
            {
                "id": 4,
                "username": "mmagwood3",
                "firstname": "Mart",
                "lastname": "Magwood",
                "email": "mmagwood3@walmart.com",
                "phonenumber": "885 528 8118",
                "street": "Vahlen",
                "housenumber": "8",
                "postalcode": "3189PA",
                "provincie": "Vérane",
                "roles": [
                    {
                        "id": 2,
                        "name": "ROLE_HANDYMAN"
                    }
                ]
            }
        ]
    },
    {
        "id": 2,
        "name": "Painter",
        "price": "90",
        "jobDescription": "paint the walls and stuff",
        "handymen": [
            {
                "id": 2,
                "username": "lturnbull1",
                "firstname": "Lucienne",
                "lastname": "Turnbull",
                "email": "lturnbull1@hhs.gov",
                "phonenumber": "690 765 9844",
                "street": "Sutherland",
                "housenumber": "73",
                "postalcode": "8315YO",
                "provincie": "Zuid-Holland",
                "roles": [
                    {
                        "id": 2,
                        "name": "ROLE_HANDYMAN"
                    }
                ]
            },
            {
                "id": 4,
                "username": "mmagwood3",
                "firstname": "Mart",
                "lastname": "Magwood",
                "email": "mmagwood3@walmart.com",
                "phonenumber": "885 528 8118",
                "street": "Vahlen",
                "housenumber": "8",
                "postalcode": "3189PA",
                "provincie": "Vérane",
                "roles": [
                    {
                        "id": 2,
                        "name": "ROLE_HANDYMAN"
                    }
                ]
            }
        ]
    },
    {
        "id": 3,
        "name": "Electrician",
        "price": "74",
        "jobDescription": "Switch a lightbulb",
        "handymen": [
            {
                "id": 4,
                "username": "mmagwood3",
                "firstname": "Mart",
                "lastname": "Magwood",
                "email": "mmagwood3@walmart.com",
                "phonenumber": "885 528 8118",
                "street": "Vahlen",
                "housenumber": "8",
                "postalcode": "3189PA",
                "provincie": "Vérane",
                "roles": [
                    {
                        "id": 2,
                        "name": "ROLE_HANDYMAN"
                    }
                ]
            },
            {
                "id": 6,
                "username": "gfranzelini5",
                "firstname": "Gino",
                "lastname": "Franzelini",
                "email": "gfranzelini5@amazon.de",
                "phonenumber": "364 170 2180",
                "street": "Grayhawk",
                "housenumber": "88",
                "postalcode": "3961H6",
                "provincie": "Flevoland",
                "roles": [
                    {
                        "id": 2,
                        "name": "ROLE_HANDYMAN"
                    }
                ]
            }
        ]
    },
    {
        "id": 4,
        "name": "Welder",
        "price": "92",
        "jobDescription": "Get some glass windows",
        "handymen": [
            {
                "id": 4,
                "username": "mmagwood3",
                "firstname": "Mart",
                "lastname": "Magwood",
                "email": "mmagwood3@walmart.com",
                "phonenumber": "885 528 8118",
                "street": "Vahlen",
                "housenumber": "8",
                "postalcode": "3189PA",
                "provincie": "Vérane",
                "roles": [
                    {
                        "id": 2,
                        "name": "ROLE_HANDYMAN"
                    }
                ]
            },
            {
                "id": 6,
                "username": "gfranzelini5",
                "firstname": "Gino",
                "lastname": "Franzelini",
                "email": "gfranzelini5@amazon.de",
                "phonenumber": "364 170 2180",
                "street": "Grayhawk",
                "housenumber": "88",
                "postalcode": "3961H6",
                "provincie": "Flevoland",
                "roles": [
                    {
                        "id": 2,
                        "name": "ROLE_HANDYMAN"
                    }
                ]
            }
        ]
    },
    {
        "id": 5,
        "name": "Gardener",
        "price": "86",
        "jobDescription": "Landscaping & weeding",
        "handymen": [
            {
                "id": 6,
                "username": "gfranzelini5",
                "firstname": "Gino",
                "lastname": "Franzelini",
                "email": "gfranzelini5@amazon.de",
                "phonenumber": "364 170 2180",
                "street": "Grayhawk",
                "housenumber": "88",
                "postalcode": "3961H6",
                "provincie": "Flevoland",
                "roles": [
                    {
                        "id": 2,
                        "name": "ROLE_HANDYMAN"
                    }
                ]
            },
            {
                "id": 8,
                "username": "cblackway7",
                "firstname": "Corrine",
                "lastname": "Blackway",
                "email": "cblackway7@house.gov",
                "phonenumber": "173 516 2375",
                "street": "Cambridge",
                "housenumber": "39",
                "postalcode": "07499R",
                "provincie": "Drenthe",
                "roles": [
                    {
                        "id": 2,
                        "name": "ROLE_HANDYMAN"
                    }
                ]
            }
        ]
    },
    {
        "id": 6,
        "name": "Locksmith",
        "price": "84",
        "jobDescription": "Need a new lock?",
        "handymen": [
            {
                "id": 6,
                "username": "gfranzelini5",
                "firstname": "Gino",
                "lastname": "Franzelini",
                "email": "gfranzelini5@amazon.de",
                "phonenumber": "364 170 2180",
                "street": "Grayhawk",
                "housenumber": "88",
                "postalcode": "3961H6",
                "provincie": "Flevoland",
                "roles": [
                    {
                        "id": 2,
                        "name": "ROLE_HANDYMAN"
                    }
                ]
            },
            {
                "id": 8,
                "username": "cblackway7",
                "firstname": "Corrine",
                "lastname": "Blackway",
                "email": "cblackway7@house.gov",
                "phonenumber": "173 516 2375",
                "street": "Cambridge",
                "housenumber": "39",
                "postalcode": "07499R",
                "provincie": "Drenthe",
                "roles": [
                    {
                        "id": 2,
                        "name": "ROLE_HANDYMAN"
                    }
                ]
            }
        ]
    },
    {
        "id": 7,
        "name": "Carpenter",
        "price": "94",
        "jobDescription": "human-resource",
        "handymen": [
            {
                "id": 8,
                "username": "cblackway7",
                "firstname": "Corrine",
                "lastname": "Blackway",
                "email": "cblackway7@house.gov",
                "phonenumber": "173 516 2375",
                "street": "Cambridge",
                "housenumber": "39",
                "postalcode": "07499R",
                "provincie": "Drenthe",
                "roles": [
                    {
                        "id": 2,
                        "name": "ROLE_HANDYMAN"
                    }
                ]
            },
            {
                "id": 10,
                "username": "kgolson9",
                "firstname": "Kasey",
                "lastname": "Golson",
                "email": "kgolson9@storify.com",
                "phonenumber": "681 396 9593",
                "street": "Pond",
                "housenumber": "66",
                "postalcode": "8412WN",
                "provincie": "Irène",
                "roles": [
                    {
                        "id": 2,
                        "name": "ROLE_HANDYMAN"
                    }
                ]
            }
        ]
    },
    {
        "id": 8,
        "name": "Fence fixer",
        "price": "80",
        "jobDescription": "Intuitive",
        "handymen": [
            {
                "id": 8,
                "username": "cblackway7",
                "firstname": "Corrine",
                "lastname": "Blackway",
                "email": "cblackway7@house.gov",
                "phonenumber": "173 516 2375",
                "street": "Cambridge",
                "housenumber": "39",
                "postalcode": "07499R",
                "provincie": "Drenthe",
                "roles": [
                    {
                        "id": 2,
                        "name": "ROLE_HANDYMAN"
                    }
                ]
            },
            {
                "id": 10,
                "username": "kgolson9",
                "firstname": "Kasey",
                "lastname": "Golson",
                "email": "kgolson9@storify.com",
                "phonenumber": "681 396 9593",
                "street": "Pond",
                "housenumber": "66",
                "postalcode": "8412WN",
                "provincie": "Irène",
                "roles": [
                    {
                        "id": 2,
                        "name": "ROLE_HANDYMAN"
                    }
                ]
            }
        ]
    },
    {
        "id": 9,
        "name": "Fire Protection",
        "price": "77",
        "jobDescription": "Function-based",
        "handymen": [
            {
                "id": 10,
                "username": "kgolson9",
                "firstname": "Kasey",
                "lastname": "Golson",
                "email": "kgolson9@storify.com",
                "phonenumber": "681 396 9593",
                "street": "Pond",
                "housenumber": "66",
                "postalcode": "8412WN",
                "provincie": "Irène",
                "roles": [
                    {
                        "id": 2,
                        "name": "ROLE_HANDYMAN"
                    }
                ]
            },
            {
                "id": 12,
                "username": "eballb",
                "firstname": "Elijah",
                "lastname": "Ball",
                "email": "eballb@sciencedirect.com",
                "phonenumber": "422 340 8369",
                "street": "Upham",
                "housenumber": "5",
                "postalcode": "2427LK",
                "provincie": "Drenthe",
                "roles": [
                    {
                        "id": 2,
                        "name": "ROLE_HANDYMAN"
                    }
                ]
            }
        ]
    },
    {
        "id": 10,
        "name": "Waterproofing & Caulking",
        "price": "92",
        "jobDescription": "Implemented",
        "handymen": [
            {
                "id": 10,
                "username": "kgolson9",
                "firstname": "Kasey",
                "lastname": "Golson",
                "email": "kgolson9@storify.com",
                "phonenumber": "681 396 9593",
                "street": "Pond",
                "housenumber": "66",
                "postalcode": "8412WN",
                "provincie": "Irène",
                "roles": [
                    {
                        "id": 2,
                        "name": "ROLE_HANDYMAN"
                    }
                ]
            },
            {
                "id": 12,
                "username": "eballb",
                "firstname": "Elijah",
                "lastname": "Ball",
                "email": "eballb@sciencedirect.com",
                "phonenumber": "422 340 8369",
                "street": "Upham",
                "housenumber": "5",
                "postalcode": "2427LK",
                "provincie": "Drenthe",
                "roles": [
                    {
                        "id": 2,
                        "name": "ROLE_HANDYMAN"
                    }
                ]
            }
        ]
    },
    {
        "id": 11,
        "name": "Roofing (Metal)",
        "price": "32",
        "jobDescription": "website",
        "handymen": []
    },
    {
        "id": 12,
        "name": "Electrical and Fire Alarm",
        "price": "29",
        "jobDescription": "Synergized",
        "handymen": []
    },
    {
        "id": 13,
        "name": "Soft Flooring and Base",
        "price": "47",
        "jobDescription": "Expanded",
        "handymen": []
    },
    {
        "id": 14,
        "name": "Waterproofing & Caulking",
        "price": "75",
        "jobDescription": "circuit",
        "handymen": []
    },
    {
        "id": 15,
        "name": "Epoxy Flooring",
        "price": "98",
        "jobDescription": "time-frame",
        "handymen": []
    },
    {
        "id": 16,
        "name": "Roofing",
        "price": "36",
        "jobDescription": "stable",
        "handymen": []
    },
    {
        "id": 17,
        "name": "Mason",
        "price": "41",
        "jobDescription": "algorithm",
        "handymen": []
    },
    {
        "id": 18,
        "name": "Broken window repair",
        "price": "48",
        "jobDescription": "Future-proofed",
        "handymen": []
    },
    {
        "id": 19,
        "name": "Toilet repair",
        "price": "64",
        "jobDescription": "upward-trending",
        "handymen": []
    },
    {
        "id": 20,
        "name": "Solar panel installation",
        "price": "88",
        "jobDescription": "holistic",
        "handymen": []
    }
]
```
![All Categories](https://user-images.githubusercontent.com/66301166/147090990-c7595040-61af-452a-abff-b63503ff96b6.png)

### GET/api/reservation/{id} 
Retrieves 1 specific reservation using the ID. Id refers to the reservation number. In this example id is 20.

Request:

- [x] Token required

body
none: This request does not have a body
Response:

body
```json
{
    "id": 20,
    "reservationDate": "12/2/2020",
    "handyman": {
        "id": 4,
        "username": "mmagwood3",
        "firstname": "Mart",
        "lastname": "Magwood",
        "email": "mmagwood3@walmart.com",
        "phonenumber": "885 528 8118",
        "street": "Vahlen",
        "housenumber": "8",
        "postalcode": "3189PA",
        "provincie": "Vérane",
        "roles": [
            {
                "id": 2,
                "name": "ROLE_HANDYMAN"
            }
        ]
    },
    "category": {
        "id": 14,
        "name": "Waterproofing & Caulking",
        "price": "75",
        "jobDescription": "circuit",
        "handymen": []
    },
    "image": null
}
```
![Get reservation by ID](https://user-images.githubusercontent.com/66301166/147091543-d4094b4d-e45a-49a8-82bb-684767952c9d.png)


### PATCH /api/reservation/{id}
With this endpoint a handyman is able to adjust a reservation. In this case the id is 5 and "reservationDate" is to be adjusted from the 
reservation. From the url it can be depicted which reservation needs to be adjusted on the basis
of the ID. Moreover, the new "reservationData" is given in the body.

Request:

- [x] Token required

body
```json
{
  "reservationDate": "11-11-2022"
}
```
Response:

body
```json
{
    "id": 5,
    "reservationDate": "11-11-2022",
    "handyman": {
        "id": 10,
        "username": "kgolson9",
        "firstname": "Kasey",
        "lastname": "Golson",
        "email": "kgolson9@storify.com",
        "phonenumber": "681 396 9593",
        "street": "Pond",
        "housenumber": "66",
        "postalcode": "8412WN",
        "provincie": "Irène",
        "roles": [
            {
                "id": 2,
                "name": "ROLE_HANDYMAN"
            }
        ]
    },
    "category": {
        "id": 18,
        "name": "Broken window repair",
        "price": "48",
        "jobDescription": "Future-proofed",
        "handymen": []
    },
    "image": null
}
```
![Update reservation](https://user-images.githubusercontent.com/66301166/147092322-dc585222-7347-4cdf-a47e-99b1ed79601c.png)

### POST /api/reservation
You can use this endpoint to make a new reservation.  

Request:

- [x] Token required


body
```json
{
  "categoryId": 7,
  "handymanId": 8,
  "customerId": 11,
  "reservationDate": "21-05-2022",
  "image": null
}
```
Response:

body
```json
{
    "id": 21,
    "reservationDate": "21-05-2022",
    "customer": {
        "id": 11,
        "username": "ltomainoa",
        "firstname": "Levon",
        "lastname": "Tomaino",
        "email": "ltomainoa@latimes.com",
        "phonenumber": "207 760 7007",
        "street": "Bunker Hill",
        "housenumber": "97",
        "postalcode": "3036YV",
        "provincie": "Overijssel",
        "roles": [
            {
                "id": 1,
                "name": "ROLE_USER"
            }
        ]
    },
    "handyman": {
        "id": 8,
        "username": "cblackway7",
        "firstname": "Corrine",
        "lastname": "Blackway",
        "email": "cblackway7@house.gov",
        "phonenumber": "173 516 2375",
        "street": "Cambridge",
        "housenumber": "39",
        "postalcode": "07499R",
        "provincie": "Drenthe",
        "roles": [
            {
                "id": 2,
                "name": "ROLE_HANDYMAN"
            }
        ]
    },
    "category": {
        "id": 7,
        "name": "Carpenter",
        "price": "94",
        "jobDescription": "human-resource",
        "handymen": [
            {
                "id": 8,
                "username": "cblackway7",
                "firstname": "Corrine",
                "lastname": "Blackway",
                "email": "cblackway7@house.gov",
                "phonenumber": "173 516 2375",
                "street": "Cambridge",
                "housenumber": "39",
                "postalcode": "07499R",
                "provincie": "Drenthe",
                "roles": [
                    {
                        "id": 2,
                        "name": "ROLE_HANDYMAN"
                    }
                ]
            },
            {
                "id": 10,
                "username": "kgolson9",
                "firstname": "Kasey",
                "lastname": "Golson",
                "email": "kgolson9@storify.com",
                "phonenumber": "681 396 9593",
                "street": "Pond",
                "housenumber": "66",
                "postalcode": "8412WN",
                "provincie": "Irène",
                "roles": [
                    {
                        "id": 2,
                        "name": "ROLE_HANDYMAN"
                    }
                ]
            }
        ]
    },
    "image": null
}
```
![New Reservation - witouth image](https://user-images.githubusercontent.com/66301166/147092856-9818ef37-8252-4a7d-a7f8-9d11159928c5.png)


### POST /api/auth/signin
After registering, you can sign in via this endpoint. Moreover, You send your name and password while signing in, and you get a token back. The received token in this case a JWT token is used to authenticate the user. This can be done for all roles. 


Request:

- [ ] Token required

body
```json
{
    "username": "lturnbull1",
    "password" : "abcd1234"
}
```
Response:

body
```json
{
    "id": 2,
    "username": "lturnbull1",
    "email": "lturnbull1@hhs.gov",
    "roles": [
        "ROLE_HANDYMAN"
    ],
    "tokenType": "Bearer",
    "accessToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJsdHVybmJ1bGwxIiwiaWF0IjoxNjQwMDAwNjI3LCJleHAiOjE2NDAwODcwMjd9.oCHdcD0dV7Am4IqbWNIWYaJ7pOk0JkMkYX-bNCo6mzwEg3tjmQYND0VMDGk1XQevebZWwqvpOLM5zJ81EBJPBA"
}
```
![SignIn](https://user-images.githubusercontent.com/66301166/147093290-eecbff1a-5ebf-46e3-ab10-005ca3702208.png)


### POST /api/auth/signup
To register as a new user, you can go to the following endpoint and fill in the registration form. For this endpoint a token is not required.

Request:

- [ ] Token required

body
```json
{
  "username": "handyman",
  "password" : "123456",
  "firstname": "handyman",
  "lastname": "handyman",
  "email" : "handyman@handyman.com",
  "phonenumber": "0612345678",
  "street": "handymanstreet",
  "housenumber": "1",
  "postalcode": "1111HM",
  "provincie": "Zuid-Holland",
  "role": ["handyman", "user"]
}
```
Response:

body
```json
{
  "message": "User registered successfully!"
}
```

![SignUp ](https://user-images.githubusercontent.com/66301166/147093646-d88da4f7-8d7a-40e9-b2aa-a446970fe2f9.png)


