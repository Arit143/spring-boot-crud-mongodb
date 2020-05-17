# spring-boot-crud-mongodb
Spring boot app for crud operations using mongodb. 

Please clone and startup the app at localhost:8080. Please make sure mongoDB is up and running.

### MongoDB setup (OSX)
https://docs.mongodb.com/manual/tutorial/install-mongodb-on-os-x/

For other OS please follow the other setup mentioned in that page. 

### What has been taken care of

1. Rest APIs. Please see the overview below for more details.
2. Exception Handling.
3. Request Validation.

### Improvements

1. Security.
2. Test cases.
3. Multiple module maven.
4. Swagger 2 UI

## Overview

Basically there are 5 rest APIs for CRUD operation for cars. You can use Postman or any other rest client to validate the API responses.


### PUT - http://localhost:8080/cars
```

Request - Make sure it is a RAW JSON

{
	"licensePlate": "XYZ-10",
	"seatCount": 10,
	"convertible": "false",
	"rating": 7,
	"engineType": "VX",
	"carManufacturer": {
		"name": "GT"
	}
}

Response - 

{
    "status": "OK",
    "message": "Data successfully inserted"
}

```

### GET - http://localhost:8080/cars
```

Response - 

[
    {
        "id": "5ec00a70965cac107ada9e42",
        "licensePlate": "XYZ-1",
        "seatCount": 6,
        "convertible": false,
        "rating": null,
        "engineType": null,
        "carManufacturer": {
            "name": "GT"
        }
    },
    {
        "id": "5ec00aac965cac107ada9e43",
        "licensePlate": "XYZ-2",
        "seatCount": 10,
        "convertible": false,
        "rating": 7,
        "engineType": "VX",
        "carManufacturer": {
            "name": "GT"
        }
    }
]

```

### GET - http://localhost:8080/cars/XYZ-1
```
Response - 
{
    "id": "5ec00a70965cac107ada9e42",
    "licensePlate": "XYZ-1",
    "seatCount": 6,
    "convertible": false,
    "rating": null,
    "engineType": null,
    "carManufacturer": {
        "name": "GT"
    }
}

```

### POST - http://localhost:8080/cars
```

Request - Make sure it is a RAW JSON and there is a valid licensePlate number to update else API will validate it with a bad request.

{
	"licensePlate": "XYZ-10",
	"seatCount": 10,
	"convertible": "false",
	"carManufacturer": {
		"name": "GT"
	}
}

Response - 

{
    "status": "OK",
    "message": "Data successfully updated"
}

```

### DELETE - http://localhost:8080/cars/XYZ-1
```
Response - 

{
    "status": "OK",
    "message": "Data successfully deleted"
}

```



