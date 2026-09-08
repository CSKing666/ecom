# E-commerce Product API

A Spring Boot REST API for managing an e-commerce product catalogue, with
manufacturing and expiry dates alongside pricing.

Built as part of full-stack Java training, covering REST controllers and Spring
Data JPA against MySQL.

## API

| Method | Path | Description |
|---|---|---|
| `POST` | `/product` | Add a product |
| `GET` | `/products` | List all products |
| `GET` | `/products/{id}` | Fetch one product |
| `PUT` | `/product` | Update a product (id in body) |
| `DELETE` | `/products/{id}` | Delete a product |

### Example

```bash
curl -X POST http://localhost:8080/product \
  -H 'Content-Type: application/json' \
  -d '{"name":"Amul Butter 500g","mfgDate":"2026-06-01",
       "expDate":"2027-06-01","price":285.00}'

curl http://localhost:8080/products
```

```json
[
  {
    "id": 1,
    "name": "Amul Butter 500g",
    "mfgDate": "2026-06-01T00:00:00.000+00:00",
    "expDate": "2027-06-01T00:00:00.000+00:00",
    "price": 285.0
  }
]
```

## Tech stack

| | |
|---|---|
| Java | 21 |
| Framework | Spring Boot 3.5.6 (Web, Data JPA) |
| Database | MySQL 8 |
| Build | Maven (wrapper included) |

## Running it locally

**Prerequisites:** JDK 21 and a running MySQL 8 server.

1. Create the database and a user for the app:

   ```sql
   CREATE DATABASE ecom CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
   CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'your-password';
   GRANT ALL PRIVILEGES ON ecom.* TO 'appuser'@'localhost';
   ```

2. Supply the credentials through the environment — they are deliberately not
   committed:

   ```bash
   export DB_USER=appuser
   export DB_PASS=your-password
   ```

3. Start the app:

   ```bash
   ./mvnw spring-boot:run
   ```

   It listens on <http://localhost:8080>. The `product` table is created
   automatically on first run (`spring.jpa.hibernate.ddl-auto=update`).

## Project layout

```
src/main/java/com/ecom/
  EcomUsingRestApiApplication.java   entry point
  controller/   ProductController
  model/        Product entity
  repository/   ProductRepository (Spring Data JPA)
  service/      ProductService
```

## Known limitations

This is a learning project, not production code:

- **Non-standard status codes** — `GET /products` returns `302 Found` and a
  successful `GET /products/{id}` returns `202 Accepted`; both should be `200 OK`.
- **`PUT` doubles as create** — it saves without checking the id exists, so a
  `PUT` with an unknown id inserts a new row instead of returning `404`.
- No authentication, request validation or pagination.
