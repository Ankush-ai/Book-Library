package BookLibrary.Booklibrary.Controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import BookLibrary.Booklibrary.Entity.Book;
import BookLibrary.Booklibrary.Service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	@Autowired
	private BookService bookService;
	
	@GetMapping
	public ResponseEntity<List<Book>> getAllBooks(){
		List<Book> books= bookService.getAllBooks();
		return new ResponseEntity<>(books, HttpStatus.OK);
	}

	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable Long id) {
		Optional<Book> book = bookService.getBookById(id);
		return book.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

	}

	@PostMapping
	public ResponseEntity<Book> createBook(@RequestBody Book book) {
		Book createdBook = bookService.createBook(book);
		return new ResponseEntity<>(createdBook, HttpStatus.OK);

	}

	@DeleteMapping("/book/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable Long id){
		bookService.deleteBook(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
