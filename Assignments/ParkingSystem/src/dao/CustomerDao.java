package dao;

import db.ParkingOps;
import model.Customer;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
    public static List<String>findAllCustomer() throws SQLException {
        List<String>customerDetails=new ArrayList<>();
        try(Connection connection= ParkingOps.getConnection()){
            PreparedStatement pst=connection.prepareStatement("SELECT * FROM Owner c JOIN Vehicle v ON c.ownerId=v.ownerId JOIN Record r ON v.registrationNo=r.registrationNo");
            ResultSet resultSet= pst.executeQuery();
            while(resultSet.next()){
                int ownerId=resultSet.getInt("ownerId");
                String name=resultSet.getString("name");
                String address=resultSet.getString("address");
                String mobileNo=resultSet.getString("mobileNo");
                String vehicleType=resultSet.getString("type");
                String model=resultSet.getString("model");
                String registrationNo=resultSet.getString("registrationNo");
                String parkingId=resultSet.getString("parkingId");
                int floor=resultSet.getInt("floor");
                LocalDateTime parkingTime=resultSet.getTimestamp("parkingTime").toLocalDateTime();
                LocalDateTime exitTime=resultSet.getTimestamp("exitTime").toLocalDateTime();
                double parkingFee=resultSet.getDouble("parkingFee");

                customerDetails.add(viewFormatter(ownerId,
                        name,
                        address,
                        mobileNo,vehicleType,
                        model,
                        registrationNo,
                        parkingId,
                        floor,
                        parkingTime,
                        exitTime,
                        parkingFee));
            }
        }
        return customerDetails;
    }
    public static boolean addCustomer(Customer customer) throws SQLException {
        try(Connection connection= ParkingOps.getConnection()){
            PreparedStatement pst=connection.prepareStatement("INSERT INTO Owner(name, address, mobileNo) VALUES (?,?,?)");
            pst.setString(1,customer.getName());
            pst.setString(2, customer.getAddress());
            pst.setString(3,customer.getMobileNo());
            int rowsUpdated=pst.executeUpdate();
            if(rowsUpdated==1) {
                System.out.println("Successfully added Customer "+customer.getName());
                return true;
            }
        }
        return false;
    }
    public static List<String> getCustomerDetails(int custId) throws SQLException {
        List<String>customerDetails=new ArrayList<>();
        try(Connection connection= ParkingOps.getConnection()){
            PreparedStatement pst=connection.prepareStatement("SELECT * FROM Owner c JOIN Vehicle v ON c.ownerId=v.ownerId JOIN Record r ON v.registrationNo=r.registrationNo WHERE c.ownerId=?");
            pst.setInt(1,custId);
            ResultSet resultSet= pst.executeQuery();
            while(resultSet.next()){
                int ownerId=resultSet.getInt("ownerId");
                String name=resultSet.getString("name");
                String address=resultSet.getString("address");
                String mobileNo=resultSet.getString("mobileNo");
                String vehicleType=resultSet.getString("type");
                String model=resultSet.getString("model");
                String registrationNo=resultSet.getString("registrationNo");
                String parkingId=resultSet.getString("parkingId");
                int floor=resultSet.getInt("floor");
                LocalDateTime parkingTime=resultSet.getTimestamp("parkingTime").toLocalDateTime();
                LocalDateTime exitTime=resultSet.getTimestamp("exitTime").toLocalDateTime();
                double parkingFee=resultSet.getDouble("parkingFee");

                customerDetails.add(viewFormatter(ownerId,
                        name,
                        address,
                        mobileNo,vehicleType,
                        model,
                        registrationNo,
                        parkingId,
                        floor,
                        parkingTime,
                        exitTime,
                        parkingFee));
            }
        }
        return customerDetails;
    }
    public static boolean deleteCustomerById(int custId) throws SQLException{
        try(Connection connection=ParkingOps.getConnection()){
            PreparedStatement pst=connection.prepareStatement("DELETE FROM Owner WHERE ownerId=?");
            pst.setInt(1,custId);

            int rowsUpdated= pst.executeUpdate();
            if(rowsUpdated==1) {
                System.out.println("Successfully deleted records of "+custId);
                return true;
            }
        }
        return false;
    }
    public static String viewFormatter(
            int ownerId,
            String name,
            String address,
            String mobileNo,
            String vehicleType,
            String model,
            String registrationNo,
            String parkingId,
            int floor,
            LocalDateTime parkingTime,
            LocalDateTime exitTime,
            double parkingFee
    ) {
        return "Owner ID     : " + ownerId + "\t" +
                "Name         : " + name + "\t" +
                "Address      : " + address + "\t" +
                "Mobile No    : " + mobileNo + "\t" +
                "Vehicle Type : " + vehicleType + "\t" +
                "Model        : " + model + "\t" +
                "Reg. No      : " + registrationNo + "\t" +
                "Parking ID   : " + parkingId + "\t" +
                "Floor        : " + floor + "\t" +
                "Parking Time : " + parkingTime + "\t" +
                "Exit Time    : " + exitTime + "\t" +
                "Parking Fee  : ₹" + String.format("%.2f", parkingFee);
    }
}
