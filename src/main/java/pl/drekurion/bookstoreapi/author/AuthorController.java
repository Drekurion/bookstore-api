package pl.drekurion.bookstoreapi.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/authors")
public class AuthorController
{
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAuthors() {
        return authorService.getAuthors();
    }

    @GetMapping(path = "{authorId}")
    public Author getAuthor(@PathVariable(name = "authorId") Long authorId) {
        return authorService.getAuthor(authorId);
    }

    @PostMapping
    public void addAuthor(@RequestBody Author author) {
        authorService.addAuthor(author);
    }

    @DeleteMapping(path = "delete/{authorId}")
    public void deleteAuthor(@PathVariable(name = "authorId") Long authorId) {
        authorService.deleteAuthor(authorId);
    }
}
