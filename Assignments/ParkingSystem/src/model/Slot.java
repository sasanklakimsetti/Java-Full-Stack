package model;

import java.util.Arrays;

public class Slot {
    int slotId;
    String slotType;
    boolean isOccupied;
    Vehicle vehicle;
    public Slot(int slotId, String slotType){
        this.slotId=slotId;
        this.slotType=slotType;
        this.isOccupied=false;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public String getSlotType() {
        return slotType;
    }

    public void setSlotType(String slotType) {
        this.slotType = slotType;
    }
    public boolean isOccupied(){
        return isOccupied;
    }
    public void occupy(Vehicle vehicle){
        this.vehicle=vehicle;
        this.isOccupied=true;
    }
    public void vacate(){
        this.vehicle=null;
        this.isOccupied=false;
    }
    public Vehicle getVehicle(){
        return vehicle;
    }
}
