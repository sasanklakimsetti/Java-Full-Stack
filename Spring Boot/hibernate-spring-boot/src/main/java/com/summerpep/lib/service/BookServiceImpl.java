package com.summerpep.lib.service;

import com.summerpep.lib.dao.BookDao;
import com.summerpep.lib.model.Book;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookServiceImpl implements BookService{
    @Autowired
    BookDao bookDao;

    @Override
    public Book findById(int bid){
        return bookDao.findById(bid);
    }
    @Override
    public List<Book> findByAuthor(String author){
        return bookDao.findByAuthor(author);
    }
}
