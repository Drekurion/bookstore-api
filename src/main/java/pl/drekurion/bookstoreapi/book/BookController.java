package pl.drekurion.bookstoreapi.book;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.drekurion.bookstoreapi.author.Author;
import pl.drekurion.bookstoreapi.author.AuthorService;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(path = "api/books")
@AllArgsConstructor
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;

    @GetMapping
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping(path = "{bookId}")
    public Book getBook(@PathVariable("bookId") Long bookId) {
        return bookService.getBook(bookId);
    }

    @PostMapping
    public void addNewBook(@RequestBody Book book) {
        Author author = authorService.getAuthor(book.getAuthor().getId());
        book.setAuthor(author);
        bookService.insertBook(book);
    }

    @DeleteMapping(path = "delete/{bookId}")
    public void deleteBook(@PathVariable("bookId") Long bookId) {
        bookService.deleteBook(bookId);
    }
}
