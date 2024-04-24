package BookLibrary.Booklibrary.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import BookLibrary.Booklibrary.Entity.Author;

public interface AuthorRepository  extends JpaRepository<Author,Long>{

}
