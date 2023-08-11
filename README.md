# Java Spring Boot RESTful API for Student Database CRUD Operations

This project demonstrates the implementation of a RESTful API using Java Spring Boot to perform CRUD (Create, Read, Update, Delete) operations on a PostgreSQL database named "student." The API focuses on managing a single table named "student" within the database.

## Table of Contents

- [Technologies Used](#technologies-used)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [API Endpoints](#api-endpoints)
- [Usage Examples](#usage-examples)


## Technologies Used

- Java Spring Boot
- PostgreSQL
- Maven
- Spring Data JPA
- Spring Web
- Spring Boot Starter Test

## Prerequisites

To run this project locally, ensure you have the following installed:

- Java Development Kit (JDK)
- PostgreSQL Database
- Apache Maven

## Getting Started

1. Clone the repository:

   ```bash
   git clone https://github.com/yourusername/student-api.git
   cd student-api
   ```

2. Configure the Database:

    - Create a PostgreSQL database named `student`.
    - Update the database connection properties in `src/main/resources/application.properties`:

      ```properties
      spring.datasource.url=jdbc:postgresql://localhost:5432/student
      spring.datasource.username=yourusername
      spring.datasource.password=yourpassword
      ```

3. Build and Run the Application:

   Navigate to the project's root directory and execute the following command:

   ```bash
   mvn spring-boot:run
   ```

   The application will start running at `http://localhost:8080`.

## API Endpoints

The following endpoints are available:

- **GET /api/v1/student**: Retrieve a list of all students.
- **GET /api/v1/student/{id}**: Retrieve a student by ID.
- **POST /api/v1/student**: Create a new student.
- **PUT /api/v1/student/{id}**: Update an existing student by ID.
- **DELETE /api/v1/student/{id}**: Delete a student by ID.

## Usage Examples

You can use tools like Postman to interact with the API. Here are some example requests:

- **GET /api/v1/student**: Retrieve all students.

  ```http
  GET http://localhost:8080/api/v1/student
  ```

- **GET /api/v1/student/{id}**: Retrieve a specific student by ID.

  ```http
  GET http://localhost:8080/api/v1/student/1
  ```

- **POST /api/v1/student**: Create a new student.

  ```http
  POST http://localhost:8080/api/v1/student
  Content-Type: application/json

  {
    "id": 1,
    "name": "John",
    "email": "john@gmail.com",
    "dob": "2000-03-01",
    age: 23
  }
  ```

- **PUT /api/v1/student/{id}**: Update an existing student.

  ```http
  PUT http://localhost:8080/students/1?name=Ali
  Content-Type: application/json

  {
    "id": 1,
    "name": "Ali",
    "email": "john@gmail.com",
    "dob": "2000-03-01",
    "age": 23
  }
  ```

- **DELETE /students/{id}**: Delete a student.

  ```http
  DELETE http://localhost:8080/students/1
  ```

Happy coding! If you have any questions, feel free to contact us at yousefnaeem22@gmail.com.