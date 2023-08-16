#Appointment Application

## Endpoints

### Customer

`GET - get all customers` 
http://localhost:8080/api/customers

`POST - Add new Customer (JSON)`
http://localhost:8080/customers 

`PUT - Edit existing Customer (Path Param id, Body JSON Customer)`
http://localhost:8080/customers/{id} -

`DELETE - Delete existing Customer (Path Param id)`
http://localhost:8080/customers/{id}

## API Documentation

### Swagger User Interface
http://localhost:8080/swagger-ui/index.html

### API Docs
http://localhost:8080/v3/api-docs

### H2 Console
http://localhost:8080/h2-console

### Build and Run Docker Image

`docker build --tag=appointments:latest .`

`docker run -p8080:8080 appointments:latest`