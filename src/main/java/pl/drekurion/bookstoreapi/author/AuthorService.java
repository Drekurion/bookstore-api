package pl.drekurion.bookstoreapi.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

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

    @Transactional
    public void updateAuthor(Long authorId, String firstName, String lastName) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new IllegalStateException("Author with id: " + authorId + "does not exist."));
        if(firstName != null && firstName.length() > 0 && !Objects.equals(author.getFirstName(), firstName))
        {
            author.setFirstName(firstName);
        }
        if(lastName != null && lastName.length() > 0 && !Objects.equals(author.getLastName(), lastName))
        {
            author.setLastName(lastName);
        }
    }

    public void deleteAuthor(Long authorId) {
        boolean exists = authorRepository.existsById(authorId);
        if(!exists) {
            throw new IllegalStateException("Author with id: " + authorId + "does not exist.");
        }
        authorRepository.deleteById(authorId);
    }
}
