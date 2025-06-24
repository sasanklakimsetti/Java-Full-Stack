package collections;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
class Point{
    int x,y;

    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public boolean equals(Object obj) {
        if(! (obj instanceof Point)) return false;
        if(this.x==((Point)obj).x&&this.y==((Point)obj).y) return true;
        return false;
    }
    public int hashCode(){
        return x;
    }
}
public class SetDemo {
    public static void main(String[] args){
        Set<String>st=new HashSet<>();
        st.add("Hello");
        st.add("Hi");
        st.add("Yes");

        for (String s:st) System.out.println(s);

        String str="Sasank";
        Set<Character>st1=new HashSet<>();
        for (char c:str.toCharArray()) st1.add(c);
        for (char i:st1) System.out.println(i);

        // Find duplicates in a word and remove them

        Set<String> set1=new HashSet<>();
        Set<String> set2=new HashSet<>();

        String str2="This is Sasank , This is Sai , Hello Hello !";

        for (String i: str2.split(" ")){
            if(set1.contains(i)) set2.add(i);
            else set1.add(i);
        }

        for (String s:set1){
            if (!set2.contains(s)) System.out.println(s);
        }

        List<Point>pointList=new ArrayList<>();
        pointList.add(new Point(2,3));
        pointList.add(new Point(1,3));
        pointList.add(new Point(2,3));
        pointList.add(new Point(6,7));
        pointList.add(new Point(1,3));

        // this will return false in general since the reference of the objects in the list is different for each.
        // We need to override the equals() and hashCode() in Point class
        // when we call list.contains(obj), it will internally call the equals method of class and checks according to the method definition
        // if not overridden, addresses will be compared by default and return false
        System.out.println(pointList.contains(new Point(2,3)));

    }
}
