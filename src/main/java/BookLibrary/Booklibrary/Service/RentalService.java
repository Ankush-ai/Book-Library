package BookLibrary.Booklibrary.Service;

import java.util.List;

import BookLibrary.Booklibrary.Entity.Rental;

public interface RentalService {
	 List<Rental> getAllRentals();
	 Rental rentBook(Rental rental);
	 void returnBook(Long id);
	 List<Rental> getOverdueRentals();

}
