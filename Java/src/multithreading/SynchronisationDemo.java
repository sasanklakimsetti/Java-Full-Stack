package multithreading;

// When same object is used by different threads, there will be problem in the execution and ambiguity will occur.
// Synchronisation is used to solve the problem. Even same object is shared by different threads, the execution will be done in synchronised manner.

class Printer{
    // without synchronized, there will be disparity in output i.e. the output will be different everytime and not in the specified format
    // sometimes it can be [[Hello]Bye] or [[Bye]Hello]
    // with synchronized, it will be always [Hello][Bye]
    // synchronized
    public void print(String msg) throws InterruptedException {
        System.out.print("[");
        Thread.sleep(1500);
        System.out.print(msg);
        System.out.print("]");
    }
}
class PrinterThread extends Thread{
    Printer p;
    String msg;
    public PrinterThread(Printer p, String msg){
        this.p=p;
        this.msg=msg;
    }
    public void run(){
        try {
            // can write like this also
            synchronized (p) {
                p.print(msg);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
public class SynchronisationDemo {
    public static void main(String[] args){
        Printer p=new Printer();
        PrinterThread p1=new PrinterThread(p,"Hello");
        PrinterThread p2=new PrinterThread(p,"Bye");
        p1.start();
        p2.start();
    }
}
