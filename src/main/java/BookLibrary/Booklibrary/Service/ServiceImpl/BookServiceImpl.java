package BookLibrary.Booklibrary.Service.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BookLibrary.Booklibrary.Entity.Book;
import BookLibrary.Booklibrary.Repository.BookRepository;
import BookLibrary.Booklibrary.Service.BookService;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();

	}

	@Override
	public Optional<Book> getBookById(Long id) {
		return bookRepository.findById(id);

	}

	@Override
	public Book createBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public Book updateBook(Long id, Book updatedBook) {
		updatedBook.setId(id);
		return bookRepository.save(updatedBook);

	}

	@Override
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}

}
