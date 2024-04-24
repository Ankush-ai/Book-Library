package BookLibrary.Booklibrary.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import BookLibrary.Booklibrary.Entity.Rental;
import BookLibrary.Booklibrary.Service.RentalService;

import java.util.List;

@RestController
@RequestMapping("/rentals")
public class RentalController {

	@Autowired
	private RentalService rentalService;

	@GetMapping
	public ResponseEntity<List<Rental>> getAllRentals() {
		List<Rental> rentals = rentalService.getAllRentals();
		return new ResponseEntity<>(rentals, HttpStatus.OK);
	}

	@PostMapping("/rent")
	public ResponseEntity<?> rentBook(@Validated @RequestBody Rental rental) {
		try {
			Rental rentedBook = rentalService.rentBook(rental);
			return new ResponseEntity<>(rentedBook, HttpStatus.CREATED);
		} catch (IllegalStateException | IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@PutMapping("/return/{id}")
	public ResponseEntity<?> returnBook(@PathVariable Long id) {
		try {
			rentalService.returnBook(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@GetMapping("/overdue")
	public ResponseEntity<List<Rental>> getOverdueRentals() {
		List<Rental> overdueRentals = rentalService.getOverdueRentals();
		return new ResponseEntity<>(overdueRentals, HttpStatus.OK);
	}
}
