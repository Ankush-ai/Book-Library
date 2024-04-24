package BookLibrary.Booklibrary.Repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import BookLibrary.Booklibrary.Entity.Rental;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {

    @Query("SELECT r FROM Rental r WHERE r.rentalDate < :currentDate") // Assuming rentalDate is the correct property
    List<Rental> findOverdueRentals(LocalDate currentDate);
}
