# Zynetic Store 🛍️ - Spring Boot + PostgreSQL(Arkopaul Halder)

A secure e-commerce API with JWT authentication and CRUD operations for book management.

---

## ✨ Features

- **JWT Authentication**
  - User Signup/Login
  - Secured API Endpoints
  - CSRF Protection
  - Session Management

- **Book Management**
  - Full CRUD Operations
  - Filtering by Author/Category/Rating
  - Search Functionality
  - Price/Rating Validation

- **Security**
  - BCrypt Password Encryption
  - Role-Based Access Control
  - Input Validation
  - Proper HTTP Status Codes

---

## ⚙️ Setup Instructions

1. Create PostgreSQL database:
```sql
   CREATE DATABASE Project_DB;
```
2. Configure application.properties
   ```http
   spring.datasource.url=jdbc:postgresql://localhost:5432/zynetic_store
   spring.datasource.username=your_db_user
   spring.datasource.password=your_db_password
   jwt.secret=your_jwt_secret_key

   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.format_sql=true
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

   logging.level.org.springframework.security = debug
   ```
4. Build & Run:
```bash
    mvn clean install
    mvn spring-boot:run
```
## 🔑 Authentication API
 ### Sign Up
     ```bash
     curl -X POST http://localhost:8080/auth/signup \
     -H "Content-Type: application/json" \
     -d '{"email":"user@example.com", "password":"securePassword123"}'
     ```
  ### Sign In
       ```bash
       curl -X POST http://localhost:8080/auth/signin \
       -H "Content-Type: application/json" \
       -d '{"email":"user@example.com", "password":"securePassword123"}'
       ```
##📚 Book API (Requires JWT Token)
  ### Create Book
     ```bash
        curl -X POST http://localhost:8080/books \
        -H "Authorization: Bearer YOUR_JWT_TOKEN" \
        -H "Content-Type: application/json" \
        -d '{
             "title":"Advanced Java",
             "author":"James Gosling",
             "category":"Programming",
             "price":499,
             "rating":4.8,
             "publishedDate":"2024-01-01"
           }'
           ```
   ### Core Operations
     ```http
         GET    /books         - List all books
         GET    /books/{id}    - Get single book
         PUT    /books/{id}    - Update book
          DELETE /books/{id}    - Delete book
          ```
  ### 🔍 Search & Filters
       ```http
             GET /books?author=J.K. Rowling
            GET /books?category=Fiction
            GET /books?rating=4.5
            GET /books?search=spring
            ```
            
     
