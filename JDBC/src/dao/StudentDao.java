package dao;

import model.Student;
import db.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// DAO: Data Accessible Object
public class StudentDao {
    public List<Student> findAll() {
        List<Student>list=new ArrayList<>();
//        Connection connection=null;
        try(Connection connection=DBConnection.getConnection()){ // writing that in the bracket, Java will close the connection automatically
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from Student");
            while (resultSet.next()){
                int roll=resultSet.getInt("rollNo");
//                String rollStr=resultSet.getString("rollNo");  // will convert int to string
//                int roll2=resultSet.getInt(0); // accessing using column number
                String name=resultSet.getString("name");
                String branch=resultSet.getString("branch");
                String mobileNo=resultSet.getString("mobileNo");

                Student s=new Student(roll, name, branch, mobileNo);
                list.add(s);
            }
            statement.close();
            resultSet.close();
            return list;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public boolean deleteByRollNo(int rollNo) throws SQLException{
        try(Connection connection=DBConnection.getConnection()){
            Statement statement=connection.createStatement();
            // executeUpdate is used to do modifications in the database
            int rowsUpdated=statement.executeUpdate("DELETE FROM Student WHERE rollNo="+rollNo);
            if(rowsUpdated==1) return true;
        }
        return false;
    }

    public Student findByRollNo(int rollNo) throws SQLException {
        Student st=null;
        try(Connection connection=DBConnection.getConnection()){
            Statement statement=connection.createStatement();
            // executeQuery is used to retrieve information from the table
            ResultSet resultSet=statement.executeQuery("SELECT * FROM Student WHERE rollNo="+rollNo);
//            if(resultSet.next()){
//                int roll=resultSet.getInt("rollNo");
//                if(roll==rollNo){
//                    String name=resultSet.getString("name");
//                    String branch=resultSet.getString("branch");
//                    String mobileNo=resultSet.getString("mobileNo");
//
//                    st=new Student(roll,name,branch,mobileNo);
//                }
//                return st;
//            }

            if(resultSet.next()){
                int roll=resultSet.getInt("rollNo");
                String name=resultSet.getString("name");
                String branch=resultSet.getString("branch");
                String mobileNo=resultSet.getString("mobileNo");

                return new Student(roll, name, branch, mobileNo);
            }
        }
        catch (SQLException e){e.printStackTrace();}
        return null;
    }

    public boolean add(Student student) throws SQLException {
        try(Connection connection=DBConnection.getConnection()){
            PreparedStatement pst=connection.prepareStatement("INSERT INTO Student VALUES(?,?,?,?)");
            // ? is used as placeholders, we can enter the input in console. They will be inserted into the table using PreparedStatement
            pst.setInt(1,student.getRollNo());
            pst.setString(2,student.getName());
            pst.setString(3,student.getBranch());
            pst.setString(4,student.getMobileNo());

            int rowsUpdated=pst.executeUpdate();  // this will give the total number of rows updated in the table

            if (rowsUpdated==1) return true;
        }
        catch (SQLException e) {e.printStackTrace();}
        return false;
    }
}
