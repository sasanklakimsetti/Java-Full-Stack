// Static Member Demo

class Student{
    int roll;
    String name;
    static int nextRoll=12200000;  // shared memory throughout the class
    public Student(String name){
        this.name=name;
        this.roll=nextRoll;
        nextRoll++;
    }
    public void show(){
        System.out.println("Name: "+name+"\n"+"Roll: "+roll);
    }
}

public class IdGenerator {
    public static void main(String[] args){
        Student s1=new Student("Sasank");
        Student s2=new Student("Karthikeya");
        Student s3=new Student("Yuvaraj");
        s1.show();
        s2.show();
        s3.show();
    }
}
