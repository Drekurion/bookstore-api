package pl.drekurion.bookstoreapi.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthorId(Long authorId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Book b WHERE b.author.id = ?1")
    void deleteByAuthorId(Long authorId);
}
