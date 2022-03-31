package pl.drekurion.bookstoreapi.book;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getBooks() {
        log.info("Fetching all books.");
        return bookRepository.findAll();
    }

    public Book getBook(Long bookId)
    {
        log.info("Fetching book by id: " + bookId);
        return bookRepository.getById(bookId);
    }

    public void addNewBook(Book book) {
        log.info("Adding new book: " + book.getTitle());
        bookRepository.save(book);
    }

    @Transactional
    public void updateBook(Book book) {
        log.info("Updating book with id: " + book.getId());
    }

    public void deleteBook(Long bookId) {
        boolean exists = bookRepository.existsById(bookId);
        if(!exists) {
            throw new IllegalStateException("Book with id " + bookId + " does not exists.");
        }
        log.info("Deleting book with id: " + bookId);
        bookRepository.deleteById(bookId);
    }
}
