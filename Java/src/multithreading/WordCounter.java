package multithreading;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class WordCounterThread extends Thread{
    int counter=0;
    File fileInfo;
    public WordCounterThread(File fileInfo){
        this.fileInfo=fileInfo;
    }
    public void run(){
        try(Scanner sc=new Scanner(new FileInputStream(fileInfo))){
            while (sc.hasNext()){
                sc.next();
                counter++;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
public class WordCounter {
    public static void main(String[] args) throws InterruptedException {
        // find all files whose name start with "a" and ends with .txt : 3 files
        // Create 3 threads, each thread counts the number of words in each file
        // get the sum of word count in main and print it
        File dirInfo=new File("./src");
        String[] files=dirInfo.list();
        List<WordCounterThread> list=new ArrayList<>();
        int count=0;
        for(String fileName:files){
            if (fileName.startsWith("a") && fileName.endsWith(".txt")) {
                File file = new File(dirInfo, fileName);
                WordCounterThread thread = new WordCounterThread(file);
                list.add(thread);
                thread.start();
            }
        }
        for (int i=0;i<list.size();i++) list.get(i).join();
        for (int i=0;i<list.size();i++) count+= list.get(i).counter;
        System.out.println(count);
    }
}
