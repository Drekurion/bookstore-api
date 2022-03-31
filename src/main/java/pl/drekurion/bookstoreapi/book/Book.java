package pl.drekurion.bookstoreapi.book;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

import static javax.persistence.GenerationType.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer numberOfPages;


    public Book(String title, String author, String description, BigDecimal price, Integer numberOfPages) {

        this.title = title;
        this.author = author;
        this.description = description;
        this.price = price;
        this.numberOfPages = numberOfPages;
    }
}
