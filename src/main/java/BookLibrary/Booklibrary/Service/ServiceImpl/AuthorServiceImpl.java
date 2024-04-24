package BookLibrary.Booklibrary.Service.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BookLibrary.Booklibrary.Entity.Author;
import BookLibrary.Booklibrary.Repository.AuthorRepository;
import BookLibrary.Booklibrary.Service.AuthorService;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public List<Author> getAllAuthors() {
		return authorRepository.findAll();
	}

	@Override
	public Optional<Author> getAuthorById(Long id) {
		return authorRepository.findById(id);
	}

	@Override
	public Author createAuthor(Author author) {
		return authorRepository.save(author);

	}

	@Override
	public Author updateAuthor(Long id, Author updatedAuthor) {
		updatedAuthor.setId(id);
		return authorRepository.save(updatedAuthor);
	}

	@Override
	public void deleteAuthor(Long id) {
		authorRepository.deleteById(id);
	}
}
