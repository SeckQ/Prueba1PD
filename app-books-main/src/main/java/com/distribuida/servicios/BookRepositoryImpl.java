package com.distribuida.servicios;

import com.distribuida.db.Book;
import io.helidon.common.reactive.Single;
import io.helidon.dbclient.DbClient;
import io.helidon.dbclient.DbRow;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepositoryImpl implements BookRepository {

    @Inject
    EntityManager entityManager;

    @Override
    public List<Book> findAllBooks() {
        return entityManager
                .createNamedQuery("Book.findAllBooks",Book.class)
                .getResultList();    }

    @Override
    public Book findBookById(Integer id) {
        return entityManager.find(Book.class,id);
    }

    @Override
    public void insertBook(Book book) {
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public void updateBook(Integer id, Book book) {
        var bookAux = this.findBookById(id);
        bookAux.setIsbn(book.getIsbn());
        bookAux.setAuthor(book.getAuthor());
        bookAux.setTitle(book.getTitle());
        bookAux.setPrice(book.getPrice());
        entityManager.persist(bookAux);
    }

    @Override
    public void deleteBook(Integer id) {
        entityManager.getTransaction().begin();
        entityManager.remove(findBookById(id));
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Book> findBookByAuthor(Integer author_id) {
        return entityManager.createNamedQuery("Book.findBookByAuthor",Book.class).setParameter("author_id",author_id).getResultList();
    }

    @Override
    public void deleteBookByAuthor(Integer author_id) {
        entityManager.getTransaction().begin();
        entityManager.remove(findBookByAuthor(author_id));
        entityManager.getTransaction().commit();
    }
}
