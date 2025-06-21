package hotelmanagement;

import java.security.Provider;
import java.util.Arrays;

public class LuxurySuite extends Suite{
    String[] services;
    public LuxurySuite(int roomNo, String roomType, int rent, String kitchenType, String[] services){
        super(roomNo, roomType, rent, kitchenType);
        this.services=services;
    }

    public String toString() {
        return "Luxury Suite [kitchenType=" + kitchenType + ", roomNo=" + roomNo + ", type=" + type + ", rent=" + rent + ", kitchen type: "+kitchenType+", Services: "+ Arrays.asList(services)+"]";
    }
}
