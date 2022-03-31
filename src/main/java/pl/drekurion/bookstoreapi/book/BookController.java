package pl.drekurion.bookstoreapi.book;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/books")
public class BookController {

    private final BookService bookService;

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
        bookService.addNewBook(book);
    }

    @PutMapping(path = "update/{bookId}")
    public void updateBook(Book book)
    {
        bookService.updateBook(book);
    }

    @DeleteMapping(path = "delete/{bookId}")
    public void deleteBook(@PathVariable("bookId") Long bookId) {
        bookService.deleteBook(bookId);
    }
}
