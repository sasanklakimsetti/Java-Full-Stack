package multithreading;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileCount {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        File dirInfo=new File("./src");  // . means current folder,  .. means parent folder
        System.out.println(dirInfo.getAbsolutePath());
        System.out.println(dirInfo.isDirectory());
        System.out.println(dirInfo.isFile());
        System.out.println(dirInfo.exists());
        System.out.println(Arrays.asList(dirInfo.list()));
        System.out.println(dirInfo.getFreeSpace());

        File fileInfo=new File("./src/a1.txt");
        System.out.println(fileInfo.getAbsolutePath());
        System.out.println(fileInfo.isFile());
        System.out.println(fileInfo.exists());
    }
}
