package pl.drekurion.bookstoreapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.drekurion.bookstoreapi.author.Author;
import pl.drekurion.bookstoreapi.author.AuthorRepository;
import pl.drekurion.bookstoreapi.author.AuthorService;
import pl.drekurion.bookstoreapi.book.Book;
import pl.drekurion.bookstoreapi.book.BookRepository;
import pl.drekurion.bookstoreapi.book.BookService;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
public class BookstoreApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApiApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(BookRepository bookRepository, AuthorRepository authorRepository) {
//		return args -> {
//			Author harris = new Author(1L,"Charlaine","Harris");
//			Author vargas = new Author("Mario", "Vargas Llosa");
//			authorRepository.saveAll(List.of(harris, vargas));
//
//			Book book1 = new Book(
//					1L,
//					"Gorzej niż martwy",
//					"Już nie tylko perypetie miłosne, nie tylko sprawy żywych..",
//					new BigDecimal("29.24"),
//					446
//					);
//			Book book2 = new Book(
//					"Marzenie celta",
//					"Co by się stało, gdyby Roger Casement nie spotkał nigdy Josepha Conrada?",
//					new BigDecimal("37.79"),
//					472
//			);
//			bookRepository.saveAll(List.of(book1, book2));
//		};
//	}
}
