# javaula-springboot-web
This is a very simple example project created for educational purpouse.

The project was created using springboot, spring-web, spring-data and H2 memory database. 

## Usage

In order to use the app you'll need an API development environment like Postman.

### Insert an employee
```POST```
URL: ```localhost:8080/empregado```
Payload:
```json
{
    "nome": "Asdrubal",
    "dataNascimento": "2000-09-04",
    "departamento": "TI"
}
```

### Get an employee by Id
```GET```
```localhost:8080/empregado/1```

### Get an employee by name
```GET```
```localhost:8080/empregado/?nome=Asdrubal```


