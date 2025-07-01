package dao;

import db.ParkingOps;
import model.Vehicle;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ParkingDao {
    public static String parkVehicle(Vehicle vehicle, int floorNumber) throws SQLException {
        try (Connection connection = ParkingOps.getConnection()) {
            PreparedStatement pst = connection.prepareStatement(
                    "SELECT slotId FROM Slot WHERE slotType = ? AND occupiedStatus = FALSE AND floorNumber = ? LIMIT 1"
            );
            pst.setString(1, vehicle.getVehicleType());
            pst.setInt(2, floorNumber);
            ResultSet rs = pst.executeQuery();

            if (!rs.next()) {
                System.out.println("No available slot for " + vehicle.getVehicleType());
                return null;
            }

            int slotId = rs.getInt("slotId");

            // 2. Mark slot as occupied
            PreparedStatement occupySlot = connection.prepareStatement(
                    "UPDATE Slot SET occupiedStatus = TRUE WHERE slotId = ? AND floorNumber = ?"
            );
            occupySlot.setInt(1, slotId);
            occupySlot.setInt(2, floorNumber);
            occupySlot.executeUpdate();

            String ticketId = generateTicket(vehicle.getVehicleType(), floorNumber, slotId, vehicle.getRegNo());

            PreparedStatement insertRecord = connection.prepareStatement(
                    "INSERT INTO ParkingRecord(ticketId, floor, registrationNo, parkingTime, parkingFee) VALUES (?, ?, ?, ?, ?)"
            );
            insertRecord.setString(1, ticketId);
            insertRecord.setInt(2, floorNumber);
            insertRecord.setString(3, vehicle.getRegNo());
            insertRecord.setDate(4, Date.valueOf(LocalDate.now()));
            insertRecord.setDouble(5,vehicle.getParkingFee());
            insertRecord.executeUpdate();

            System.out.println("Vehicle parked in slot #" + slotId + " on floor " + floorNumber);
            System.out.println("Generated Ticket ID: " + ticketId);

            return ticketId;
        }
    }

//    public static boolean unparkVehicle(String ticketId) throws SQLException {
//        try(Connection connection=ParkingOps.getConnection()){
//
//        }
//    }

    private static String generateTicket(String vehicleType, int floor, int slot, String regNo) {
        return vehicleType + "_" + floor + "_" + slot + "_" + regNo;
    }
}
