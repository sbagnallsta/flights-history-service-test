# Flights History Service

## Synopsis
Flights History Service is responsible for storing and retrieving data in the Flights History DB

## Installation
### Eclipse
### go 
### Docker
```sh

```

### Dependencies 
- 
- 


## Health Checks
### Readiness
| Description | Value |
| ------ | ------ |
| Type | HTTP GET request on container port 3000 |
| Period | Every 60 seconds |
| Success | 1 attempt |
| Failure | 3 attempts |

### Liveness

## Services

| Services | Location |
| ------ | ------ |
| Swagger | http://flights-history-service.40.68.36.110.nip.io/documentation |
| Docker | https://hub.docker.com/r/statravel/flights-history-service/ |
| Sonarqube | http://sonarqube.40.68.36.110.nip.io/ |
| Pacts | http://pact-broker.40.68.36.110.nip.io/ |
| MS Teams Channel| https://tofilllater.com |

## Endpoints

| Endpoint | Method |Service |
| ------ | ------ | ------ |
| /health | GET | health cheking api |
| /flights | GET | retrieving data |
| /flights | POST | storing data |