package model;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private final List<Floor>floors=new ArrayList<>();
    public ParkingLot(int numberOfFloors){
        for (int i=0;i<numberOfFloors;i++){
            Floor floor=new Floor(i+1);
            floors.add(floor);
        }
    }
    public String parkVehicle(Vehicle vehicle) {
        for (Floor floor : floors) {
            String ticketId = floor.parkVehicle(vehicle);
            if (ticketId != null) return ticketId;
        }
        System.out.println("Parking Lot Full for: " + vehicle.getVehicleType());
        return null;
    }
    public boolean unparkVehicle(String regNo){
        for (Floor floor:floors){
            if(floor.unparkVehicle(regNo)) return true;
        }
        return false;
    }
}
