// If the base class does not have a default (no-arg) constructor,
// then the derived class must explicitly call a parameterized constructor using super().
// Otherwise, the compiler will try to insert an implicit call to super(), which will cause an error.

package inheritance;
class Person{
    String name;
    String address;
//    public Person(){
//        System.out.println("Person created");
//    }
    public Person(String name, String address){
        this.name=name;
        this.address=address;
    }
    public void showPerson(){
        System.out.println("Name: "+name);
        System.out.println("Address: "+address);
    }
    public void show(){
        System.out.println("This is Person");
    }
}
class Student extends Person{
    int roll;
    String branch;
    public Student(String name, String address, int roll, String branch){
        super(name, address); // this will use the parameterized constructor of the parent class
        this.roll=roll;
        this.branch=branch;
    }
    public void showStudent(){
        // No need to use super for inherited fields unless there's a naming conflict or shadowing.
        System.out.println("Name: "+super.name);
        System.out.println("Address: "+super.address);
        System.out.println("Roll: "+roll);
        System.out.println("Branch: "+branch);
    }
    public void show(){
        System.out.println("This is Student");
    }
}
public class Inheritance1 {
    public static void main(String[] args){
        Student s1=new Student("Sasank","Tanuku",17,"CSE");
        s1.showStudent();

        // superclass variable = subclass object
        // exp: Person has only name and address, and Student has name,address, roll, branch
        // so we have all members of Person in Student

        // If we write Student s1 = p1; it will cause a compile-time error,
        // because not all members of Student are present in the Person reference.
        // You would need to cast it explicitly and ensure it's safe using instanceof.

        Person p1=s1;
        // we can only access the members which are present in Person. If we want to access roll, it will be an error since there is no field in Person
        // let's say they are two functions in Base and Derived with same name, Derived's will be called
        // if there is no function with the same name in both Base and Derived, then the Base class can't access the function as well. Only possible if functions are present with same signature and arguments
        // Runtime polymorphism allows the base class reference to invoke overridden methods of the derived class.
        // But it cannot access newly added methods or fields of the derived class unless cast explicitly.
        System.out.println(p1.name);
        System.out.println(p1.address);
        //System.out.println(p1.roll);  // error
        p1.show();
    }
}