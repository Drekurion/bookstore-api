package pl.drekurion.bookstoreapi.book;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.drekurion.bookstoreapi.author.Author;
import pl.drekurion.bookstoreapi.author.AuthorRepository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import static java.math.BigDecimal.*;

@Service
@Slf4j
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public List<Book> getBooks() {
        log.info("Fetching all books.");
        return bookRepository.findAll();
    }

    public Book getBook(Long bookId)
    {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalStateException("Book with id " + bookId + " does not exist."));
    }

    @Transactional
    public void insertBook(Book book) {
        Author author = authorRepository.findById(book.getAuthor().getId())
                .orElseThrow(() -> new IllegalStateException("Author with id: " + book.getAuthor().getId() + "does not exist."));
        book.setAuthor(author);
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

    @Transactional
    public void updateBook(Long bookId, String title, String description, BigDecimal price, Integer numberOfPages, Long authorId)
    {
        Book book = getBook(bookId);
        if(title != null && title.length() > 0 && !Objects.equals(book.getTitle(), title))
        {
            book.setTitle(title);
        }
        if(description != null && description.length() > 0 && !Objects.equals(book.getDescription(), description))
        {
            book.setDescription(description);
        }
        if(price != null && price.compareTo(ZERO) > 0 && price.compareTo(book.getPrice()) != 0)
        {
            book.setPrice(price);
        }
        if(numberOfPages != null && numberOfPages > 0 && !numberOfPages.equals(book.getNumberOfPages()))
        {
            book.setNumberOfPages(numberOfPages);
        }
        if(authorId != null && authorId > 0 && !authorId.equals(book.getAuthor().getId()))
        {
            Author author = authorRepository.findById(authorId)
                    .orElseThrow(() -> new IllegalStateException("Author with id: " + authorId + "does not exist."));
            book.setAuthor(author);
        }
    }
}
