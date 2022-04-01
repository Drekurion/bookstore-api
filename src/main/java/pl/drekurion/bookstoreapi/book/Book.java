package pl.drekurion.bookstoreapi.book;

import lombok.*;

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
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "book_sequence"
    )
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer numberOfPages;

    public Book(String title, String description, BigDecimal price, Integer numberOfPages) {

        this.title = title;
        this.description = description;
        this.price = price;
        this.numberOfPages = numberOfPages;
    }
}
