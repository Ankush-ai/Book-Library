package BookLibrary.Booklibrary.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Author {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@NotBlank(message = "Name is required")
	private String biography;
	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", biography=" + biography + "]";
	}
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Author(Long id, String name, @NotBlank(message = "Name is required") String biography) {
		super();
		this.id = id;
		this.name = name;
		this.biography = biography;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBiography() {
		return biography;
	}
	public void setBiography(String biography) {
		this.biography = biography;
	}

}
