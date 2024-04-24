

# Book Library Spring Boot Application

This Spring Boot application provides RESTful endpoints to manage a book library. It supports CRUD operations for books, authors, and book rentals.

## Project Structure

### Entity Package
- **Book**: Contains fields like `id`, `title`, `author`, `isbn`, and `publicationYear`.
- **Author**: Contains fields like `id`, `name`, and `biography`.
- **Rental**: Represents a book rental, with fields `id`, `book`, `renterName`, `rentalDate`, and `returnDate`.

### Repository Package
- **BookRepository**: Repository interface for managing Book entities.
- **AuthorRepository**: Repository interface for managing Author entities.
- **RentalRepository**: Repository interface for managing Rental entities.

### Service Package
- **BookService**: Service interface for managing Book entities.
- **AuthorService**: Service interface for managing Author entities.
- **RentalService**: Service interface for managing Rental entities.
- **BookServiceImpl**: Implementation class for BookService.
- **AuthorServiceImpl**: Implementation class for AuthorService.
- **RentalServiceImpl**: Implementation class for RentalService.

### Controller Package
- **BookController**: RESTful controller for managing books.
- **AuthorController**: RESTful controller for managing authors.
- **RentalController**: RESTful controller for managing book rentals.

## RESTful Endpoints

- **Books**:
  - GET `/books`: Get all books.
  - POST `books`: Add a new book.
  - GET `books/{id}`: Get book by ID.
  - PUT `/books/{id}`: Update book by ID.
  - DELETE `/books/{id}`: Delete book by ID.
- **Authors**:
  - GET `/authors`: Get all authors.
  - POST `/authors`: Add a new author.
  - GET `/authors/{id}`: Get author by ID.
  - PUT `/authors/{id}`: Update author by ID.
  - DELETE `/authors/{id}`: Delete author by ID.
- **Rentals**:
  - GET `/rentals`: Get all rentals.
  - POST `/rentals`: Rent a book.
  - GET `/rentals/{id}`: Get rental by ID.
  - PUT `/rentals/{id}`: Return a rented book by ID.

## Dependencies Used
- Spring Web
- MySQL
- DevTools
- Hibernate
- Validation
- SQL
- MySQL Database

## Cloning and Running the Project

1. Clone the repository:
   ```
   git clone https://github.com/Ankush-ai/Book-Library.git
   ```

2. Navigate to the project directory:
   ```
   cd book-library
   ```

3. Configure MySQL database settings in `application.properties`.

4. Run the application using Maven:
   ```
   mvn spring-boot:run
   ```

5. Once the application is running, you can access the endpoints using the provided URLs.

## Sample Requests to Test Endpoints

### Add a Book
```http
POST /books
Content-Type: application/json

{
  "title": "Sample Book",
  "author": {
    "name": "John Doe",
    "biography": "Sample biography"
  },
  "isbn": "1234567890",
  "publicationYear": 2022
}
```

### Get All Books
```http
GET /api/books
```

### Rent a Book
```http
POST /rentals
Content-Type: application/json

{
  "bookId": 1,
  "renterName": "Alice",
  "rentalDate": "2024-04-25",
  "returnDate": "2024-05-25"
}
```

### Return a Rented Book
```http
PUT /rentals/1
Content-Type: application/json

{
  "returnDate": "2024-05-05"
}
```
