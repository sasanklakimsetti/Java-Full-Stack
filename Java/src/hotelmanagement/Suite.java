package hotelmanagement;

public class Suite extends Room{
    String kitchenType;
    public Suite(int roomNo, String type, int rent, String kitchenType){
        super(roomNo, type, rent);
        this.kitchenType=kitchenType;
    }
    public String toString() {
        return "Suite [kitchenType=" + kitchenType + ", roomNo=" + roomNo + ", type=" + type + ", rent=" + rent + ", kitchen type: "+kitchenType+"]";
    }
}
