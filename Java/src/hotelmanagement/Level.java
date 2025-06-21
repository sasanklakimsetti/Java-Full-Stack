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
            if(room.getClass()== Suite.class) count++;
        }
        if(count<1||count>3) throw new RuntimeException();
    }

    public String toString(){
        return "Level [rooms=" + rooms + ", levelno=" + levelNo + "]";
    }
}
