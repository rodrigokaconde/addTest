# addTest

<p>Api created for add test.</p>

## Back-End

### Resources used
- Java
- Lombok
- JPA
- Maven
- Swagger
- Docker
- PostgreSQL

### Create database
```docker run --name app-db -d -p 5433:5432 -e POSTGRES_USER=postgres_user -e POSTGRES_PASSWORD=super123 -e POSTGRES_DB=add postgres```

### Endpoints

#### Escola:
```http://localhost:8090/escola```

#### Endereco:
```http://localhost:8090/endereco```

#### Turma:
```http://localhost:8090/turma```

#### Aluno:
```http://localhost:8090/aluno```

### Swagger documentation:
```http://localhost:8090/swagger-ui.html```
