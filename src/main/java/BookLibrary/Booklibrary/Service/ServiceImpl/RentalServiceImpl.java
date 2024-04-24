package BookLibrary.Booklibrary.Service.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BookLibrary.Booklibrary.Entity.Rental;
import BookLibrary.Booklibrary.Repository.BookRepository;
import BookLibrary.Booklibrary.Repository.RentalRepository;
import BookLibrary.Booklibrary.Service.RentalService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class RentalServiceImpl implements RentalService {
	@Autowired
	private RentalRepository rentalRepository;

	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Rental> getAllRentals() {
		return rentalRepository.findAll();
	}

	@Override
	public Rental rentBook(Rental rental) {
		Optional<BookLibrary.Booklibrary.Entity.Book> bookOptional = bookRepository.findById(rental.getBook().getId());
		if (bookOptional.isPresent()) {
			BookLibrary.Booklibrary.Entity.Book book = bookOptional.get();
			if (book.isAvailable()) {
				// Set rental date and mark the book as rented
				rental.setRentalDate(LocalDate.now());
				book.setAvailable(false);
				rental.setBook(book);
				return rentalRepository.save(rental);
			} else {
				throw new IllegalStateException("The book is already rented.");
			}
		} else {
			throw new IllegalArgumentException("Book not found.");
		}
	}

	@Override
	public void returnBook(Long id) {
		Optional<Rental> rentalOptional = rentalRepository.findById(id);
		if (rentalOptional.isPresent()) {
			Rental rental = rentalOptional.get();
			// Mark the book as available
			rental.getBook().setAvailable(true);
			// Set return date
			rental.setReturnDate(LocalDate.now());
			rentalRepository.deleteById(id);
		} else {
			throw new IllegalArgumentException("Rental not found.");
		}
	}

	@Override
	public List<Rental> getOverdueRentals() {
		// Implement logic to retrieve overdue rentals (if rentalDate + 14 days <
		// currentDate)
		LocalDate currentDate = LocalDate.now();
		LocalDate fourteenDaysAgo = currentDate.minusDays(14);
		return rentalRepository.findOverdueRentals(fourteenDaysAgo);
	}

}
