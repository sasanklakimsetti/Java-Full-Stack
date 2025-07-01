package model;

import java.util.List;
import java.util.Locale;

public class Floor {
    static int floorNumber;
    static List<Slot>slots;
    // private static boolean[] slotsAvailable=new boolean[100];
    public Floor(int floorNumber){
        this.floorNumber=floorNumber;
        for (int i=0;i<10;i++) slots.add(new Slot(i,"Truck"));
        for(int i=10;i<50;i++) slots.add(new Slot(i,"Car"));
        for (int i=50;i<100;i++) slots.add(new Slot(i, "Bike"));
    }
    public static String parkVehicle(Vehicle vehicle){
        for (Slot slot:slots){
            if (slot.getSlotType().equalsIgnoreCase(vehicle.getVehicleType())&&!slot.isOccupied()){
                slot.occupy(vehicle);
                String ticketId=generateTicket(vehicle.getVehicleType(),floorNumber,slot.getSlotId(),vehicle.getRegNo());
                System.out.println("Vehicle parked in slot #" + slot.getSlotId() + " on floor " + floorNumber);
                System.out.println("Generated Ticket ID: " + ticketId);
                return ticketId;
            }
        }
        System.out.println("No available slot for " + vehicle.getVehicleType());
        return null;
    }
    public static boolean unparkVehicle(String regNo){
        for (Slot slot : slots) {
            if (slot.isOccupied() && slot.getVehicle().getRegNo().equalsIgnoreCase(regNo)) {
                slot.vacate();
                System.out.println("Vehicle with registration number " + regNo + " unparked from slot #" + slot.getSlotId() + " on floor " + floorNumber);
                return true;
            }
        }
        System.out.println("Vehicle with registration number " + regNo + " not found on floor " + floorNumber);
        return false;
    }
    public static String generateTicket(String type, int floorNumber, int slotId, String regNo){
        return type.toUpperCase()+"_"+floorNumber+"_"+slotId+"_"+regNo;
    }
}
