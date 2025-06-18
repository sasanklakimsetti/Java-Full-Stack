package inheritance;
class Figure{
    public double getArea(){
        return 0;
    }
}
class Rectangle extends Figure{
    double length, width;
    public Rectangle(double length, double width){
        this.length=length;
        this.width=width;
    }
    public double getArea(){
        return length*width;
    }
}
class Circle extends Figure{
    double radius;
    public Circle(double radius){
        this.radius=radius;
    }
    public double getArea(){
        return radius*radius;
    }
}
public class RuntimePolymorphism {
    public static void main(String[] args){
        Figure f1=new Figure();
        Figure f2=new Figure();
        Rectangle r1=new Rectangle(11,12);
        Rectangle r2=new Rectangle(17,17);

        Circle c1=new Circle(18);
        Circle c2=new Circle(25);

        Figure arr[]={f1,r1,r2,c1,c2};

        for(int i=0;i<arr.length-1;i++){
            System.out.println(sumOfAreas(arr[i],arr[i+1]));
        }
    }

    // we can give arguments of the method using Figure class and call the function using either of the Rectangle or Circle, or the both.
    // Since all these classes are inherited from Figure, we can provide those objects in the place of Figure objects in the method
    public static double sumOfAreas(Figure f1, Figure f2){
        return f1.getArea()+f2.getArea();
    }
}