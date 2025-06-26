package studentmanagementsystem.db;

import com.mysql.cj.jdbc.MysqlDataSource;
import studentmanagementsystem.dao.StudentDao;
import studentmanagementsystem.model.Student;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DBConnection {
    public static Connection getConnection() throws SQLException {
        MysqlDataSource ds=new MysqlDataSource();
        ds.setPassword("Sasank17@");
        ds.setUser("root");
        // currently the database is in local, so localhost. port number depends on the machine. Generally 3306
        ds.setUrl("jdbc:mysql://localhost:3306/jdbc");
        Connection connection=ds.getConnection();
        return connection;
    }

    public static void main(String[] args) throws SQLException {
//        Connection connection=null;
        try{
//            connection=DBConnection.getConnection();
//            System.out.println(connection);
            StudentDao dao=new StudentDao();
            List<Student>list=dao.findAll();
            System.out.println(list);

            Student st1=new Student(105,"Sasank","CSE","9133931410");
            dao.add(st1);
            list=dao.findAll();
            System.out.println(list);

            Student s2=dao.findByRollNo(105);
            System.out.println(s2);
            s2.setName("Sai Sasank");
            dao.update(s2);

            System.out.println(s2);

            dao.deleteByRollNo(101);
            list=dao.findAll();
            System.out.println(list);
        } catch (Exception e){
            e.printStackTrace();
        }
//        finally {
//            connection.close();
//        }
    }
}
