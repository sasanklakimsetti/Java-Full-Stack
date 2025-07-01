package dao;

import db.ParkingOps;
import model.Vehicle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao {
    public static boolean addVehicle(Vehicle vehicle) throws SQLException {
        try(Connection connection= ParkingOps.getConnection()) {
            PreparedStatement pst=connection.prepareStatement("INSERT INTO Vehicle (registrationNo, model, type) VALUES (?, ?, ?)");
            pst.setString(1,vehicle.getRegNo());
            pst.setString(2,vehicle.getModel());
            pst.setString(3,vehicle.getVehicleType());

            int rowsUpdated=pst.executeUpdate();
            if(rowsUpdated==1){
                System.out.println("Successfully added vehicle");
                return true;
            }
        }
        return false;
    }

    public static boolean deleteVehicle(String regNo) throws SQLException {
        try(Connection connection=ParkingOps.getConnection()){
            PreparedStatement pst=connection.prepareStatement("DELETE FROM Vehicle WHERE registrationNo=?");
            pst.setString(1,regNo);

            int rowsUpdated=pst.executeUpdate();
            if(rowsUpdated==1){
                System.out.println("Deleted vehicle with Registration No: "+regNo);
                return true;
            }
        }
        return false;
    }

    public static List<String> findVehicleByRegNo(String regNo) throws SQLException {
        List<String> vehicleDetails=new ArrayList<>();
        try(Connection connection= ParkingOps.getConnection()){
            PreparedStatement pst=connection.prepareStatement("SELECT * FROM Vehicle v JOIN Owner c ON c.ownerId=v.ownerId JOIN Record r ON v.registrationNo=r.registrationNo WHERE v.registrationNo LIKE ?");
            pst.setString(1,regNo);
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

                vehicleDetails.add(viewFormatter(
                        vehicleType,
                        model,
                        registrationNo,
                        ownerId,
                        name,
                        address,
                        mobileNo,
                        parkingId,
                        floor,
                        parkingTime,
                        exitTime,
                        parkingFee));
            }
        }
        return vehicleDetails;
    }
    public static String viewFormatter(
            String vehicleType,
            String model,
            String registrationNo,
            int ownerId,
            String name,
            String address,
            String mobileNo,
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
