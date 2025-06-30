# API de Catálogo de Livros com Spring Boot

Este projeto foi desenvolvido como parte do desafio do bootcamp Santander Backend Java DIO 2025.

## Descrição

A aplicação é uma API RESTful que permite gerenciar um catálogo de livros, com funcionalidades de cadastro, edição, listagem e busca por título ou autor.

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3.5.0
- Spring Web
- Spring Data JPA
- MySQL
- Maven
- Swagger (Springdoc OpenAPI)
- Eclipse IDE

## Estrutura do Projeto

- `model`: Entidade Livro
- `repository`: Interface JPA
- `service`: Lógica de negócio
- `controller`: Endpoints REST
- `swagger`: Documentação automática via `/swagger-ui.html`

## Endpoints disponíveis

- `GET /livros`: listar todos os livros
- `GET /livros/{id}`: buscar livro por ID
- `GET /livros/titulo/{titulo}`: buscar por título
- `GET /livros/autor/{autor}`: buscar por autor
- `POST /livros`: cadastrar novo livro
- `PUT /livros/{id}`: atualizar livro
- `DELETE /livros/{id}`: excluir livro


## Autor

Projeto desenvolvido por Josevan Tavares como parte do desafio prático da DIO.

