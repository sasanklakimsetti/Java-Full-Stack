package hotelmanagement;

public class Room {
    int roomNo;
    String type;
    int rent;
    public Room(int roomNo, String type, int rent){
        this.roomNo=roomNo;
        this.type=type;
        this.rent=rent;
    }
    public String toString() {
        return "Room [roomNo=" + roomNo + ", type=" + type + ", rent=" + rent + "]";
    }
}
