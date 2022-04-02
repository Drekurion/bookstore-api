package pl.drekurion.bookstoreapi.book;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.drekurion.bookstoreapi.author.Author;
import pl.drekurion.bookstoreapi.author.AuthorService;

import java.math.BigDecimal;
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

    @PutMapping(path = "update/{bookId}")
    public void updateBook(@PathVariable("bookId") Long bookId,
                           @RequestParam(required = false) String title,
                           @RequestParam(required = false) String description,
                           @RequestParam(required = false) BigDecimal price,
                           @RequestParam(required = false) Integer numberOfPages,
                           @RequestParam(required = false) Long authorId)
    {
        bookService.updateBook(bookId, title, description, price, numberOfPages, authorId);
    }

    @PostMapping
    public void addNewBook(@RequestBody Book book) {
        bookService.insertBook(book);
    }

    @DeleteMapping(path = "delete/{bookId}")
    public void deleteBook(@PathVariable("bookId") Long bookId) {
        bookService.deleteBook(bookId);
    }
}
