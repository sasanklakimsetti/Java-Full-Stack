package abstractclasses;

class Point{
    int x, y;
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }
    // overriding existing equals method of Object Class
    public boolean equals(Object obj){
        Point p1=(Point) obj;
        return this.x==p1.x && this.y==p1.y;
    }
}
public class AbstractClasses2 {
    public static void main(String[] args){
        Point p1=new Point(2,3);
        Point p2=new Point(6,5);
        Point p3=new Point(6,5);
        System.out.println(p1==p2);
        System.out.println(p2==p3);
        System.out.println(p1.equals(p2));
        System.out.println(p2.equals(p3));
        System.out.println(p2.hashCode());
    }
}
