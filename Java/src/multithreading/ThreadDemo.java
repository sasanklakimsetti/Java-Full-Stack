package multithreading;

//When you extend the Thread class, you are creating a new thread by subclassing it.
class MyThread extends Thread {
    public void run() {
        for (int i = 1; i <= 100; i++) System.out.println("child1 " + i);
    }
}

// When you implement Runnable, you're just creating a task (i.e., the code that runs in a thread), not a thread itself.
class ChildThread implements Runnable {
    public void run() {
        for (int i = 1; i <= 100; i++) System.out.println("child2 " + i);
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();  // this will call run() method internally

        ChildThread ct = new ChildThread();
        Thread t2 = new Thread(ct);  // we type-casted it into thread because we are using Runnable to implement ChildThread and Runnable is an interface
        t2.start();

        for (int i = 1; i <= 100; i++) System.out.println("Main " + i);
    }
}