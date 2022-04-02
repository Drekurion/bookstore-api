package pl.drekurion.bookstoreapi.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.drekurion.bookstoreapi.author.Author;

import javax.persistence.*;
import java.math.BigDecimal;

import static javax.persistence.GenerationType.IDENTITY;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table
public class Book {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer numberOfPages;

    @ManyToOne(optional = false)
    @JoinColumn(
            name = "author_id",
            referencedColumnName = "id",
            nullable = false
    )
    private Author author;

    public Book(String title, String description, BigDecimal price, Integer numberOfPages) {

        this.title = title;
        this.description = description;
        this.price = price;
        this.numberOfPages = numberOfPages;
    }

    public Book(Long id, String title, String description, BigDecimal price, Integer numberOfPages) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.numberOfPages = numberOfPages;
    }
}
