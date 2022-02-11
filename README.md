# Cake Topper Order Manager API
This a REST API made with Java and Spring Boost. It implements a system for managing cake toppers orders and has the following dependencies:
 - Spring Web;
 - Spring Data JPA;
 - OpenFeign;
 - H2 Database;
 - OpenAPI/Swagger-ui
H2 Database was chosen to simplify the tests.

This API has two RestControllers, one to manage clients (cliente-controller) e another to manage the orders (agenda-topo-rest-controller). It is possible to:
 - Create new clients: it requires name, phone and zipcode of the client (it only works with Brazilian zipcode, called CEP, becouse it retrieves the address based on this code).
 - Update clients: passing the client's Id, you can change their name, phone or zip code.
 - See all clients.
 - See a single client passing their Id.
 - Create new order: creates a new order using the cake topper's name, cost, delivery date and client's Id.
 - Update order: you can change the cake topper's name, cost and delivery date passing the order's Id.
 - Delete order: delete a order, selected by passing its Id.
 - See all orders.
 - See a single order passing its Id.

## For testing

For testing on browsers using Swagger-ui, you can run the application and go to the following web adress: http://localhost/swagger-ui.html. Bellow, there are some suggestions to make the requests to the options that change the database (POST, PUT):

Create new clients:
```
{
    "nome": "Ana",
    "telefone": "7859546",
    "endereco": {
      "cep": "66085005"
    }
}
```
Update client:
```
{
  "id": 1,
  "nome": "Ana",
  "telefone": "981200121",
  "endereco": {
    "cep": "66085005"
  }
}
```
Create order:
```
{
  "nomeProjeto": "Naruto",
  "valor": "R$50,00",
  "dataEntrega": "2022-02-15",
  "cliente": {
    "id": 1
    }
  }
}
```
Update order:
```
{
  "id": 1,
  "nomeProjeto": "Sonic",
  "valor": "R$60,00",
  "dataEntrega": "2022-02-21",
  "cliente": {
    "id": 1
    }
  }
}
```
