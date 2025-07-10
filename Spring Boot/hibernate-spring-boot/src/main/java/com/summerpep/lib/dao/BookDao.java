package com.summerpep.lib.dao;
import com.summerpep.lib.model.Book;
import java.util.List;

public interface BookDao {
    // on one table CRUD operations
    List<Book>findAll();
    Book findById(int bid);
    Book add(Book book);
    boolean remove(Book book);
    Book update(Book book);
    List<Book>findByAuthor(String author);
}
