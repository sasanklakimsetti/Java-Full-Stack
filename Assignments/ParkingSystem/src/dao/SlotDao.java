package dao;

import db.ParkingOps;
import model.Slot;
import model.Vehicle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SlotDao {
    public boolean addSlot(Slot slot) throws SQLException {
        try(Connection connection= ParkingOps.getConnection()){
            PreparedStatement pst=connection.prepareStatement("INSERT INTO Slot(slotId, slotType, occupiedStatus) VALUES(?,?,?)");
            pst.setInt(1,slot.getSlotId());
            pst.setString(2,slot.getSlotType());
            pst.setString(3,slot.isOccupied()?"Occupied":"Unoccupied");
            pst.executeUpdate();
            int rowsUpdated=pst.executeUpdate();
            if(rowsUpdated==1){
                System.out.println("Slot added successfully");
                return true;
            }
        }
        return false;
    }
    public void parkVehicle(Vehicle vehicle){

    }
}
