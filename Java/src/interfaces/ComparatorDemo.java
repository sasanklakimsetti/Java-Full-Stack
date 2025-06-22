package interfaces;

import java.util.Arrays;
import java.util.Comparator;

class Point implements Comparable<Point>{
    int x, y;
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }
    public String toString(){
        return "Point [x="+x+", y="+y+"]";
    }
    @Override
    public int compareTo(Point o) {
        if(this.x>o.x) return 1;
        else if(this.x<o.x) return -1;
        return 0;
    }
}
public class ComparatorDemo {
    public static void main(String[] args){
        Point[] ar={new Point(3,4), new Point(1,1), new Point(3,9)};
        Arrays.sort(ar);
        System.out.println(Arrays.toString(ar));
        class PointComparator implements Comparator<Point>{
            public int compare(Point o1, Point o2){
//              if(o1.y > o2.y ) return +ve;
//				if(o1.y < o2.y ) return -ve;
//				else return 0;
                return o1.y-o2.y;
            }
        }
        PointComparator comp=new PointComparator();

        Arrays.sort(ar, comp);
        System.out.println(Arrays.toString(ar));
    }
}
