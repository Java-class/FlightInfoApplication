# Flight Info Application

The Spring Boot based Application for manage Flight Info and Cargo

## Table of Content

- Tech Stack
- Run And Deployment
- API Reference
- Authors
- Social Media Links
- GitHub Repository


## Tech Stack

- Java 17
- Spring Boot 3.1.0
- Maven
- Postgres DB
- Test Container

## Run And Deployment

For run this project, you must install docker first and after that doing flowing steps.

- Pull the latest Redis image and start the postgres container on port 5432
- Build Artifact with maven and start flight info application with java command.
- Or run with docker compose with command docker-compose up -d

## API Reference 
 - Get Cargo weight

```http
  GET http://localhost:8081/api/cargo/weight?flightNumber=FLA1A-0A06&flightDate=2023-06-13T08:00:00&sumType=CARGO
```


- Get Airport Flight Count

```http
  GET http://localhost:8081/api/airport/flightCount?airportCode=ARP1&flightDate=2023-06-13T08:00:00&flightType=DEPARTING
```
- Get Airport Cargo Count

```http
  GET http://localhost:8081/api/airport/cargoCount?airportCode=ARP1A&flightDate=2023-06-13T08:00:00&flightType=TOTAL&cargoType=TOTAL
```



## Authors

- [@Mostafa Anbarmoo](https://www.github.com/java-class)

## 🔗 Social Media Links

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/mostafa-anbarmoo)

## GitHub Repository

You can find all project source code in my GitHub repository
(https://github.com/Java-class/TR-Candlestick)
