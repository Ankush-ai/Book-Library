package BookLibrary.Booklibrary.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import BookLibrary.Booklibrary.Entity.Book;

public interface BookRepository extends JpaRepository<Book,Long>{

}
