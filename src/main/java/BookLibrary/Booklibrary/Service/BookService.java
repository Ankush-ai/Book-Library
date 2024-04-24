package BookLibrary.Booklibrary.Service;
import java.util.List;
import java.util.Optional;

import BookLibrary.Booklibrary.Entity.Book;
public interface BookService {
	List<Book> getAllBooks();
	Optional<Book> getBookById(Long id);
	Book createBook(Book book);
	Book updateBook(Long id, Book updatedBook);
	void deleteBook(Long id);

}
