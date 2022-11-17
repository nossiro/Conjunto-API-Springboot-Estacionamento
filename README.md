# Conjunto-API-Springboot-Estacionamento
Nesse projeto foi desenvolvido um um conjunto de API’s utilizando Spring Boot para controlar um estacionamento de veículos. Nele, são controlados a entrada, saída e valor a ser cobrado do cliente. Foram utilizadas as boas práticas de desenvolvimento de API’s incluindo segurança com Spring Security e acesso a banco de dados PostgreSQL.

## Run database
docker run --name parking-db -p 5432:5432 -e POSTGRES_DB=parking -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=123 -d postgres:10-alpine