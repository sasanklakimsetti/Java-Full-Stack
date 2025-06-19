package interfaces;

import java.util.Arrays;

// if a class contains an abstract method, then the class must be abstract
// whereas a class can be abstract though there are no abstract methods in it.
abstract class FigureClass{
    double dimension[];
    int numAngles;
    boolean closedFigure;
    abstract public double area();
}

// no need of signature as abstract before any method in interfaces since there will be abstract methods.
// Till Java 8, interfaces should only have abstract methods,
// but after that there is a change brought that interfaces can have default, static methods as well
// variables can only be public, final, static
// in interfaces, all data members and methods are public by default
// cannot have constructors

// purpose: used to define a contract or a set of behaviours

// differences between default and static methods
// default methods can be overridden whereas static methods can't be overridden
// default methods are instance methods i.e. they belong to individual objects of a class
// static methods are class methods i.e. they belong to the class and can be called without an instance
interface Figure{
    public String COLOR="Black";
    public double Area();
    public default void draw(){
        System.out.println("A figure is drawing");
    }
    public static double sum(Figure[] arr){
        double s=0;
        for(Figure fig:arr) s+=fig.Area();
        return s;
    }
}
interface Picture{
    double[] dimensions();
}
// if any class implements an interface, it must implement all the abstract methods.
// Otherwise, the class should be declared abstract.

// a class can implement multiple interfaces whereas a class can't inherit multiple classes
// java has no mechanism to handle multiple inheritance like C++
// C++ has virtual keyword to handle but in java, there is no keyword like that
class Rectangle implements Figure, Picture{
    double len, wid;
    public Rectangle(double len, double wid){
        this.len=len;
        this.wid=wid;
    }
    public double Area(){return len*wid;}

    @Override
    public void draw() {
        System.out.println("Drawing a rectangle");
    }

    @Override
    public double[] dimensions() {
        return new double[] {len,wid};
    }
}

class Circle implements Figure{
    double radius;
    public Circle(double radius){
        this.radius=radius;
    }
    public double Area(){
        return 3.14*radius*radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

// if we have object of class to some restricted values, enum is the good option
// enums contain only objects
// so if we want to fix certain number of objects for a class we can use enums
public class Interface1 {
    public static void main(String[] args){
        // we can't create an object of an interface since it is a contract
        // Figure f=new Figure() ;  // error
        // we can give the interface as a reference
        Rectangle f;
        // base class variable = derived class object
        f=new Rectangle(5,4);
        System.out.println(f.Area());
        f.draw();
        System.out.println(f.dimensions()); // will print the hashcode of the array
        System.out.println(Arrays.toString(f.dimensions())); // will print the array
    }
}