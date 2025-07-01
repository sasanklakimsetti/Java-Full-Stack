package db;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ParkingOps {
    public static Connection getConnection() throws SQLException {
        MysqlDataSource ds=new MysqlDataSource();
        ds.setPassword("Sasank17@");
        ds.setUser("root");
        ds.setUrl("jdbc:mysql://localhost:3306/jdbc");
        Connection connection=ds.getConnection();
        return connection;
    }
    public static void main(String[] args){
    }
}
