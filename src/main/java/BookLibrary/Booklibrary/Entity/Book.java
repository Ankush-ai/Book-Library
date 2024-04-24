package BookLibrary.Booklibrary.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "Title is required")
	private String title;

	@ManyToOne
	@NotNull(message = "Author is required")
	private Author author;

	@NotBlank(message = "ISBN is required")
	@Pattern(regexp = "\\d{3}-\\d{10}", message = "ISBN must be in the format 'xxx-xxxxxxxxxx'")
	private String isbn;

	@NotNull(message = "Publication year is required")
	private Integer publicationYear;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", publicationYear="
				+ publicationYear + "]";
	}

	public Book() {
		super();
		
	}

	public Book(Long id, @NotBlank(message = "Title is required") String title, Author author,
			@NotBlank(message = "ISBN is required") @Pattern(regexp = "\\d{3}-\\d{10}", message = "ISBN must be in the format 'xxx-xxxxxxxxxx'") String isbn,
			@NotNull(message = "Publication year is required") Integer publicationYear) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.publicationYear = publicationYear;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(Integer publicationYear) {
		this.publicationYear = publicationYear;
	}

	public boolean isAvailable() {
		
		return false;
	}

	public void setAvailable(boolean b) {
		
	}

}
