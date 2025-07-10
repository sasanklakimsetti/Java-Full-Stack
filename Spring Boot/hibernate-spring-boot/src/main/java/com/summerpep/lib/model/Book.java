package com.summerpep.lib.model;

import jakarta.persistence.*;

@Entity
public class Book {
    @SequenceGenerator(name = "bookidseq", initialValue = 10, allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int bid;
    String title;
    String author;
    Double price;

    @Override
    public String toString() {
        return "Book{" +
                "bid=" + bid +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
