package bookmanagementsystem.dao;

import bookmanagementsystem.model.Book;
import studentmanagementsystem.db.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    public boolean addBook(Book book){
        try(Connection connection= DBConnection.getConnection()){
            PreparedStatement pst=connection.prepareStatement("INSERT INTO Book VALUES (?,?,?,?,?,?,?)");
            pst.setInt(1,book.getBookId());
            pst.setString(2,book.getBookName());
            pst.setString(3,book.getAuthor());
            pst.setString(4,book.getGenre());
            pst.setString(5,book.getPublisher());
            pst.setDate(6,book.getPublishedDate());
            pst.setDouble(7,book.getPrice());

            int rowsUpdated=pst.executeUpdate();
            if(rowsUpdated==1) {
                System.out.println("Insertion done for BookId= "+book.getBookId());
                return true;
            }
        } catch (SQLException e){e.printStackTrace();}
        return false;
    }

    public Book findByBookId(int bookId){
        try(Connection connection=DBConnection.getConnection()){
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM Book WHERE bookId="+bookId);

            if (resultSet.next()){
                int id=resultSet.getInt("bookId");
                String bookName=resultSet.getString("bookName");
                String author=resultSet.getString("author");
                String genre=resultSet.getString("genre");
                String publisher=resultSet.getString("publisher");
                Date publishedDate=resultSet.getDate("publishedDate");
                double price=resultSet.getDouble("price");

                return new Book(id, bookName, author, genre, publisher, publishedDate, price);
            }
        } catch (SQLException e){e.printStackTrace();}
        return null;
    }

    public boolean deleteByBookId(int bookId){
        try(Connection connection=DBConnection.getConnection()) {
            Statement statement=connection.createStatement();
            int rowsUpdated= statement.executeUpdate("DELETE FROM Book WHERE bookId="+bookId);
            if(rowsUpdated==1) {
                System.out.println("Insertion done for BookId= "+bookId);
                return true;
            }
        } catch (SQLException e) {e.printStackTrace();}
        return false;
    }

    public boolean update(Book book){
        try(Connection connection=DBConnection.getConnection()) {
            PreparedStatement pst= connection.prepareStatement("UPDATE Book SET bookName=?, author=?, genre=?, publisher=?, publishedDate=?, price=? WHERE bookId=?");
            pst.setString(1, book.getBookName());
            pst.setString(2,book.getAuthor());
            pst.setString(3,book.getGenre());
            pst.setString(4, book.getPublisher());
            pst.setDate(5,book.getPublishedDate());
            pst.setDouble(6,book.getPrice());
            pst.setInt(7,book.getBookId());

            int rowsUpdated=pst.executeUpdate();
            if(rowsUpdated==1) {
                System.out.println("Updation done for BookId= "+book.getBookId());
                return true;
            }
        } catch (SQLException e) {e.printStackTrace();}
        return false;
    }

    public List<Book> findAll(){
        List<Book> list=new ArrayList<>();
        try(Connection connection=DBConnection.getConnection()){
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM Book");
            while (resultSet.next()){
                int bookId=resultSet.getInt("bookId");
                String bookName=resultSet.getString("bookName");
                String author=resultSet.getString("author");
                String genre=resultSet.getString("genre");
                String publisher=resultSet.getString("publisher");
                Date publishedDate=resultSet.getDate("publishedDate");
                double price=resultSet.getDouble("price");

                list.add(new Book(bookId,bookName,author,genre,publisher,publishedDate,price));
            }
        } catch (SQLException e) {e.printStackTrace();}
        return list;
    }
}
