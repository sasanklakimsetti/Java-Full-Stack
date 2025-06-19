package interfaces;

import java.util.Arrays;

class Point implements Comparable<Point>{
    int x, y;
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public int compareTo(Point o) {
        if(this.x>o.x) return 1;
        else{
            if(this.y>o.y) return 1;
        }
        return 0;
    }
}
public class ComparatorDemo {
    public static void main(String[] args){
        Point p1=new Point(3,4);
    }
}
