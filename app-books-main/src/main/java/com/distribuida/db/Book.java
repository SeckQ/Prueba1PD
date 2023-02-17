package com.distribuida.db;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "book",description = "Schema of Book", title = "Book Schema")
@Table(name = "books")
@NamedQuery(name = "Book.findAllBooks",query = "SELECT b FROM Book b")
@NamedQuery(name = "Book.findBookByAuthor",query = "SELECT b FROM Book b WHERE b.author= :authorId")
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Schema(required = true,example = "11-11", minimum = "1", maximum = "100", description = "String")
    @Column(name = "isbn")
    private String isbn;

    @Schema(required = true, example = "Title1", minimum = "1", maximum = "100", description = "String")
    @Column(name = "title")
    private String title;

    @Schema(required = true, example = "Author1", minimum = "1", maximum = "100", description = "Integer")
    @Column(name = "author_id")
    private Integer author;

    @Schema(required = true, example = "111.11", minimum = "1", maximum = "100", description = "BigDecimal")
    @Column(name = "price")
    private BigDecimal price;
}
