package multithreading;

// Simulate Hare and Tortoise problem by creating 2 threads Hare and Tortoise that has the problem of counting 1 to 100,
// where tortoise wins consistently counting and hare sleeps after 90% completion.

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class Hare extends Thread{
    public void run(){
        for (int i=1;i<=100;i++){
            if(i%10==0) System.out.println("Hare crossed "+i+" meters");
            if(i==90) {
                System.out.println("At "+LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss"))+", Hare started sleeping...");
                try {
                    sleep(50000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Hare won the race at "+LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss")));
    }
}
class Tortoise extends Thread{
    public void run(){
        for (int i=0;i<=100;i++){
            if(i%10==0) System.out.println("Tortoise crossed "+i+" meters");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Tortoise won the race at "+ LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss")));
    }
}
public class HareAndTortoise {
    public static void main(String[] args){
        System.out.println("Race started..");
        Hare h1=new Hare();
        Tortoise t1=new Tortoise();
        h1.start();
        t1.start();
    }
}
