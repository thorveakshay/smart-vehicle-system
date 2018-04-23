# Smart Vehicle System

## Functionality covered

All RESTful endpoints working. Tested using Postman

Note: On official [**test client**](https://estimate-dev.mymitchell.com/codingchallenge/v1/index.html#/) update and delete is not working. There is some error with crosssite somain "CORS" but I tested the same on Postman all functions are working as expected.

````
GET vehicles
GET vehicles/{id}
POST vehicles
PUT vehicles
DELETE vehicles/{id}
````
* Implemented validation to service.
    - Vehicles must have a non-null / non-empty make and model specified, and the year must be
    between 1950 and 2050.

## Requirements

1.  Java - 1.8.x

2.  Maven - 3.x.x


## Steps to Setup

###Direct URL
##### I deployed webservice on Heroku(Cloud Service) with internal git CI/CD.
Service URL: https://smart-vehicle.herokuapp.com/

### Code Setup

** 1. Get the code repo **

** 2. Build and run the backend app using maven**

```bash
cd smart-vehicle-system
mvn package
java -jar target/smart-vehicle-system-1.0.jar
```

Alternatively, you can run the app without packaging it using

```bash
cd smart-vehicle-system
mvn spring-boot:run
```

The backend localhost service will start at <http://localhost:8080>.


Endpoints:
````
localhost
http://localhost:8080/vehicles
http://localhost:8080/vehicles/1

cloud service
https://smart-vehicle.herokuapp.com/vehicles
https://smart-vehicle.herokuapp.com/vehicles/1
````

Try below on postman:

POST request on --> http://localhost:8080/vehicles

````
{
//use below JSON data object
// ID is autogenerated

        "Year": 2000,
        "Make": "Ford",
        "Model": "Mustang"
    }
````


PUT request on ---> http://localhost:8080/vehicles
````
{
//use below JSON data object

	"Id": 5,
        "Year": 2018,
        "Make": "Ford",
        "Model": "Mustang 2018"
    }
````

DELETE request on --> http://localhost:8080/vehicles/4


## Unit test Coverage
100% classes covered, 78% lines covered.