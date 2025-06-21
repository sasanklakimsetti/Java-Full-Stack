package hotelmanagement;

import java.util.List;

public class Hotel {
    String name, address;
    List<Level> levels;

    public Hotel(String name, String address, List<Level>levels){
        super();
        this.name=name;
        this.address=address;
        this.levels=levels;
    }

    public String toString(){
        return "Hotel [name: "+name+"\nAddress: "+address+"\nLevels: "+levels+"]";
    }
}
