package hotelmanagement;

import java.util.ArrayList;
import java.util.List;

public class HotelOps {
    public static void main(String[] args){
        List<Room>rooms1=new ArrayList<>();
        rooms1.add(new Room(101,"Normal",2000));
        rooms1.add(new Room(102,"AC Room",3000));
        rooms1.add(new Suite(103,"Suite",6000,"South Indian"));

        List<Room> rooms2=new ArrayList<>();
        rooms2.add(new Room(201,"Normal",2000));
        rooms2.add(new Room(202,"AC Room",3000));
        rooms2.add(new Suite(203,"Suite",6000,"North Indian"));

        // this will return a Runtime Exception since there are no Suite rooms i.e. Suite objects
//        List<Room> rooms2=new ArrayList<>();
//        rooms2.add(new Room(201,"Normal",2000));
//        rooms2.add(new Room(202,"AC Room",3000));
//        rooms2.add(new Room(203,"Suite",6000));

        List<Level>levels=new ArrayList<>();
        Level l1=new Level(rooms1,1);
        Level l2=new Level(rooms2,2);

        levels.add(l1);
        levels.add(l2);

        Hotel hotel=new Hotel("What a Stay!","Punjab",levels);
        System.out.println(hotel);
    }
}
