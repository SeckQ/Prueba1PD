package com.distribuida.servicios;

import com.distribuida.db.Author;
import com.distribuida.db.AuthorRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class AuthorServiceImpl implements AuthorService{

    @Inject
    private AuthorRepository authorRepository;
    @Override
    public Author findAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public List<Author> findAllAuthors() {
        return authorRepository.listAll();
    }

    @Transactional
    @Override
    public void insertAuthor(Author author) {
        authorRepository.persist(author);
    }

    @Transactional
    @Override
    public void updateAuthor(Author author, Long id) {
        authorRepository.update("first_name = ?1, last_name = ?2 where id = ?3",author.getFirst_name(),author.getLast_name(),author.getId());
    }

    @Transactional
    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}