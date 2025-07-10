package com.summerpep.lib.service;

import com.summerpep.lib.model.Book;

import java.util.List;

public interface BookService {
    Book findById(int bid);
    List<Book> findByAuthor(String author);
}
