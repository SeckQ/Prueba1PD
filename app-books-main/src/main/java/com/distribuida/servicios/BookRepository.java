package com.distribuida.servicios;

import com.distribuida.db.Book;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

public interface BookRepository {
    List<Book> findAllBooks();

    Book findBookById(Integer id);

    void insertBook(Book book);

    void updateBook(Integer id,Book book);

    void deleteBook(Integer id );

    List<Book> findBookByAuthor(Integer author_id);

    void deleteBookByAuthor(Integer author_id);
}
