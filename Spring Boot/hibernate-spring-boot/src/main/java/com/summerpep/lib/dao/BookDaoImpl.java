package com.summerpep.lib.dao;

import com.summerpep.lib.model.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookDaoImpl implements BookDao{
    @Autowired
    EntityManagerFactory factory;

    // on one table, CRUD operations
    public List<Book>findAll(){
        EntityManager em=factory.createEntityManager();
        Query query=em.createQuery("select b from Book b");
        List<Book>list=query.getResultList();
        return list;
    }
    public Book findById(int bid){
        EntityManager em=factory.createEntityManager();
        Book book=em.find(Book.class, bid);
        return book;
    }
    public Book add(Book book){
        EntityManager em=factory.createEntityManager();
        em.persist(book);
        return book;
    }
    public boolean remove(Book book){
        EntityManager em=factory.createEntityManager();
        em.remove(book);  // error: if book is not persistent object, ??
        return true;
    }
    public Book update(Book book){
        EntityManager em=factory.createEntityManager();
        em.persist(book);
        return book;
    }
    public List<Book>findByAuthor(String author){
        EntityManager em=factory.createEntityManager();
        Query query=em.createQuery("select b from Book b where b.author= :author");
        query.setParameter("author", author);
        List<Book>list=query.getResultList();
        return list;
    }
}
