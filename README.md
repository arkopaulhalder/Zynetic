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
    mvn clean install
    mvn spring-boot:run

## 🔑 Authentication API
 ### Sign Up
     curl -X POST http://localhost:8080/auth/signup \
     -H "Content-Type: application/json" \
     -d '{"email":"user@example.com", "password":"securePassword123"}'
     
  ### Sign In
       curl -X POST http://localhost:8080/auth/signin \
       -H "Content-Type: application/json" \
       -d '{"email":"user@example.com", "password":"securePassword123"}'
  
##📚 Book API (Requires JWT Token)
  ### Create Book
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
           
   ### Core Operations
         GET    /books         - List all books
         GET    /books/{id}    - Get single book
         PUT    /books/{id}    - Update book
         DELETE /books/{id}    - Delete book
      
  ### 🔍 Search & Filters
            GET /books?author=J.K. Rowling
            GET /books?category=Fiction
            GET /books?rating=4.5
            GET /books?search=spring
     
  ### CRUD APIs Screenshots
  #### 1. Create a New Book (POST)
  ![Create](https://github.com/user-attachments/assets/e75d0282-08b3-4009-8168-4631bf5f8b2d)
  #### 2. Get All Books (GET)
  ![Read](https://github.com/user-attachments/assets/1e3d64d2-ba23-4ba6-a53e-3be500824013)
  #### 3. Get Book by ID (GET)
  ![image](https://github.com/user-attachments/assets/49ed38ef-9730-4ca1-8ada-0604ac286945)
  #### 4. Update Book by ID (PUT)
   ![image](https://github.com/user-attachments/assets/82024e06-a76a-44e1-ab27-73cd1adb024f)
  #### 5. Delete Book by ID (DELETE)
   ![image](https://github.com/user-attachments/assets/4f2fd78c-1fe5-4891-a105-d85a136c1541)

               
  ### Database Screenshots After The Above CRUD Operations
  #### Books
  ![image](https://github.com/user-attachments/assets/5e9f1d74-3158-442d-9aba-330b6203b12a)

  #### Users
  ![Query the users](https://github.com/user-attachments/assets/0c5a6a12-02c3-47d5-8920-10362574e14b)
