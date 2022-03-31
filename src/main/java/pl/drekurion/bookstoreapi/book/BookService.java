package pl.drekurion.bookstoreapi.book;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {
        log.info("Fetching all books.");
        return bookRepository.findAll();
    }

    public Book getBook(Long bookId)
    {
        log.info("Fetching book by id: " + bookId);
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalStateException("Book with id " + bookId + " does not exist."));
    }

    public void insertBook(Book book) {
        log.info("Inserting book: " + book.getTitle());
        bookRepository.save(book);
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
