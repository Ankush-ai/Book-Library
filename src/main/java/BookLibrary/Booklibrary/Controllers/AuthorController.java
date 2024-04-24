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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import BookLibrary.Booklibrary.Entity.Author;
import BookLibrary.Booklibrary.Service.AuthorService;

@RestController
@RequestMapping("/author")
public class AuthorController {
	@Autowired
	private AuthorService authorService;

	@GetMapping
	public ResponseEntity<List<Author>> getAllAuthors() {
		List<Author> authors = authorService.getAllAuthors();
		return new ResponseEntity<>(authors, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
		Optional<Author> author = authorService.getAuthorById(id);
		return author.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping
	public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
		Author createdAuthor = authorService.createAuthor(author);
		return new ResponseEntity<>(createdAuthor, HttpStatus.CREATED);

	}

	@PutMapping("/author/{id}")
	public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody Author author) {
		Author updatedAuthor = authorService.updateAuthor(id, author);
		return new ResponseEntity<>(updatedAuthor, HttpStatus.OK);
	}

	@DeleteMapping("/author/{id}")
	public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
		authorService.deleteAuthor(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
