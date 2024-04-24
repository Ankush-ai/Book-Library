package BookLibrary.Booklibrary.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Rental {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@NotNull(message="Book is Required")
	private Book book;
	
	@NotBlank(message="Renter name is Required")
	private String renterName;
	
	 @NotNull(message = "Rental date is required")
	    private LocalDate rentalDate;

	    private LocalDate returnDate;

		public Rental() {
			super();
			
		}

		@Override
		public String toString() {
			return "Rental [id=" + id + ", book=" + book + ", renterName=" + renterName + ", rentalDate=" + rentalDate
					+ ", returnDate=" + returnDate + "]";
		}

		public Rental(Long id, @NotNull(message = "Book is Required") Book book,
				@NotBlank(message = "Renter name is Required") String renterName,
				@NotNull(message = "Rental date is required") LocalDate rentalDate, LocalDate returnDate) {
			super();
			this.id = id;
			this.book = book;
			this.renterName = renterName;
			this.rentalDate = rentalDate;
			this.returnDate = returnDate;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Book getBook() {
			return book;
		}

		public void setBook(Book book) {
			this.book = book;
		}

		public String getRenterName() {
			return renterName;
		}

		public void setRenterName(String renterName) {
			this.renterName = renterName;
		}

		public LocalDate getRentalDate() {
			return rentalDate;
		}

		public void setRentalDate(LocalDate rentalDate) {
			this.rentalDate = rentalDate;
		}

		public LocalDate getReturnDate() {
			return returnDate;
		}

		public void setReturnDate(LocalDate returnDate) {
			this.returnDate = returnDate;
		}

}
