# 📚 GraphQL Book Management API

This project is a simple **Spring Boot** application demonstrating a **GraphQL** API for managing books.  
It supports creating new books and querying books from an in-memory **H2 database**.

---

## ✨ Features

- Create a new Book using GraphQL mutation
- Fetch all Books
- Fetch a single Book by ID
- Uses Spring Boot, GraphQL, JPA, and H2 database

---

## 📦 Project Structure

- **Entity:** `Book.java` — Defines the Book object model.
- **Repository:** `BookRepo.java` — Extends JPA repository for database operations.
- **Service:** `BookServiceImpl.java` — Contains business logic for book operations.
- **Controller:** `BookController.java` — GraphQL queries and mutations mapped here.
- **GraphQL Schema:** Defined using `Book`, `BookInput`, Query, and Mutation types.

---

## 🔧 Technologies Used

- Java 21+
- Spring Boot 3.x
- Spring for GraphQL
- Spring Data JPA
- H2 Database (in-memory)
- GraphQL Query Language

---

## 🚀 Running the Project

### Prerequisites

- Java 21 or higher installed
- Maven installed

### Steps

1. **Clone the Repository**

```bash
git clone https://github.com/athrocks/GraphQL-SpringBoot.git
cd GraphQL-SpringBoot
```

2. **Run the Application**

```bash
./mvnw spring-boot:run
```

Or if you use Maven installed globally:

```bash
mvn spring-boot:run
```

3. **Access GraphQL Playground**

Visit:

```
http://localhost:8009/graphql
```
*(Or your configured GraphQL client.)*

---

## 📖 Sample Queries & Mutations

### Create a Book (Mutation)

```graphql
mutation {
  createBook(book: {
    title: "Java Techie",
    desc: "Java Learn",
    price: 453,
    pages: 1245,
    author: "Atharva"
  }) {
    id
  }
}
```

### Fetch All Books (Query)

```graphql
query {
  allBooks {
    id
    title
    price
  }
}
```

### Fetch Book by ID (Query)

```graphql
query {
  getBook(bookId: 2) {
    title
    desc
  }
}
```

---

## 🛠️ Application Configuration (`application.properties`)

```properties
spring.application.name=
server.port=8009

spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=
spring.datasource.password=

spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

- Access H2 console at `http://localhost:8009/h2-console`
- JDBC URL: `jdbc:h2:mem:testdb`

---

## 📄 GraphQL Schema

```graphql
type Mutation {
  createBook(book: BookInput): Book
}

type Query {
  allBooks: [Book]
  getBook(bookId: Int): Book
}

type Book {
  id: ID!
  title: String
  desc: String
  author: String
  price: Float
  pages: Int
}

input BookInput {
  title: String
  desc: String
  author: String
  price: Float
  pages: Int
}
```

---
