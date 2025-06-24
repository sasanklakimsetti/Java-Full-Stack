package collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo {
    public static void main(String[] args){
        Map<String,Integer>mp=new HashMap<>();
        mp.put("Sasank",17);
        mp.put("Sai",16);
        mp.put("Sasank",18);  // if the key is repeated, the value will be overridden

        System.out.println(mp.get("Sasank"));

        Set<String> keySet=mp.keySet();
        Collection<Integer>values=mp.values();
        Set<Map.Entry<String, Integer>>entrySet=mp.entrySet();
        mp.remove("Amit");

        for (String s:keySet) System.out.println(s);
        for (Integer i:values) System.out.println(i);
    }
}
