package pl.drekurion.bookstoreapi.book;

import lombok.*;
import pl.drekurion.bookstoreapi.author.Author;

import javax.persistence.*;
import java.math.BigDecimal;

import static javax.persistence.GenerationType.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table
public class Book {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer numberOfPages;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "author_id",
            referencedColumnName = "id")
    private Author author;

    public Book(String title, String description, BigDecimal price, Integer numberOfPages, Author author) {

        this.title = title;
        this.description = description;
        this.price = price;
        this.numberOfPages = numberOfPages;
        this.author = author;
    }
}
