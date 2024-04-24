package BookLibrary.Booklibrary.Service;

import java.util.List;
import java.util.Optional;

import BookLibrary.Booklibrary.Entity.Author;

public interface AuthorService {
	List<Author> getAllAuthors();
	Optional<Author> getAuthorById(Long id);
	Author createAuthor(Author author);
	Author updateAuthor(Long id,Author updadedAuthor);
	void deleteAuthor(Long id);

}
