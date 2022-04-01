package pl.drekurion.bookstoreapi.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService
{
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthor(Long authorId) {
        return authorRepository.findById(authorId).orElseThrow(() ->
                new IllegalStateException("Author with id: " + authorId + "does not exist."));
    }

    public void addAuthor(Author author) {
        authorRepository.save(author);
    }

    public void deleteAuthor(Long authorId) {
        boolean exists = authorRepository.existsById(authorId);
        if(!exists) {
            throw new IllegalStateException("Author with id: " + authorId + "does not exist.");
        }
        authorRepository.deleteById(authorId);
    }
}
