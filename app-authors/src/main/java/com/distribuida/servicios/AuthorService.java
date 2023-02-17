package com.distribuida.servicios;

import com.distribuida.db.Author;

import java.util.List;

public interface AuthorService {
    Author findAuthorById(Long id);
    List<Author> findAllAuthors();
    void insertAuthor(Author author);
    void updateAuthor (Author author, Long id);
    void deleteAuthor (Long id);
}

