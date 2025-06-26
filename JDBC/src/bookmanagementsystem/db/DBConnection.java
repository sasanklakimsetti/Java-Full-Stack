package bookmanagementsystem.db;

import bookmanagementsystem.dao.BookDao;
import bookmanagementsystem.model.Book;
import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class DBConnection {
    public Connection  getConnection() throws SQLException {
        MysqlDataSource ds=new MysqlDataSource();
        ds.setPassword("Sasank17@");
        ds.setUser("root");
        ds.setUrl("jdbc:mysql://localhost:3306/jdbc");
        Connection connection= ds.getConnection();
        return connection;
    }

    public static void main(String[] args){
        try {
            BookDao dao=new BookDao();

            dao.addBook(new Book(201,"Why Not","James","Inspirational","MVT Publishers", Date.valueOf("2024-05-22"),550.75));
            dao.addBook(new Book(202,"Yes Not","Tames","Comedy","MVT Publishers", Date.valueOf("2024-01-02"),250.75));
            dao.addBook(new Book(203,"Finding Myself","Sasank","Life","MVT Publishers", Date.valueOf("2022-10-02"),750.75));
            List<Book> books=dao.findAll();
            System.out.println(books);

            Book bookFind=dao.findByBookId(202);
            System.out.println(bookFind);
            bookFind.setPublisher("JVR Pusblishers");
            dao.update(bookFind);

            books=dao.findAll();
            System.out.println(books);

            dao.deleteByBookId(202);
            books=dao.findAll();
            System.out.println(books);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
