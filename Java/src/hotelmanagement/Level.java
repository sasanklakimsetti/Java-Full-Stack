package hotelmanagement;

import java.util.List;

public class Level {
    List<Room>rooms;
    int levelNo;
    public Level(List<Room>rooms, int levelNo){
        super();
        this.rooms=rooms;
        checkValidity(rooms);
        this.levelNo=levelNo;
    }
    private void checkValidity(List<Room>rooms){
        int count=0;
        for(Room room:rooms){
            // The Suite Rooms will be counted only if it is the object of Suite Class. It won't be counted if the object is an instance of subclasses of Suite.
            if(room.getClass()== Suite.class) count++;
        }
        // a level must have atleast have 1 Suite Room and no.of rooms must also be less than 3
        if(count<1||count>3) throw new RuntimeException();
    }

    public String toString(){
        return "Level [rooms=" + rooms + ", levelno=" + levelNo + "]";
    }
}
