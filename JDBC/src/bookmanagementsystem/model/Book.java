package bookmanagementsystem.model;

import java.sql.Date;

public class Book {
    private int bookId;
    private String bookName, author, genre, publisher;
    private Date publishedDate;
    private Double price; // Using Wrapper class to allow null values
    // Although every book is expected to have a price,
    // there might be scenarios (e.g., incomplete data from the database)
    // where the price is null.
    // Primitive types like 'double' can't hold null values,
    // but wrapper classes like 'Double' can.

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publishedDate=" + publishedDate +
                ", price=" + price + "}\n";
    }

    public Book() {}

    public Book(int bookId, String bookName, String author, String genre, String publisher, Date publishedDate, double price) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
        this.price = price;
    }
    public int getBookId() {return bookId;}
    public void setBookId(int bookId) {this.bookId = bookId;}
    public String getBookName() {return bookName;}
    public void setBookName(String bookName) {this.bookName = bookName;}
    public String getAuthor() {return author;}
    public void setAuthor(String author) {this.author = author;}
    public String getGenre() {return genre;}
    public void setGenre(String genre) {this.genre = genre;}
    public String getPublisher() {return publisher;}
    public void setPublisher(String publisher) {this.publisher = publisher;}
    public Date getPublishedDate() {return publishedDate;}
    public void setPublishedDate(Date publishedDate) {this.publishedDate = publishedDate;}
    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}
}
