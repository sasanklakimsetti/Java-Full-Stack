package exceptionhandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandling1 {
    // we can't use the File Stream without throwing FileNotFoundException and IOException since they are Checked exceptions
    // not for this, for every checked exceptions we need to use throw those exceptions
    public static void copyFile(String inputFile, String outputFile) throws FileNotFoundException, IOException {
        FileInputStream fis=new FileInputStream(inputFile);
        FileOutputStream fout=new FileOutputStream(outputFile);
        int ch=fis.read();
        while(ch!=-1){
            fout.write(ch);
            ch=fis.read();
        }
    }
    public static void main(String[] args){
        int x,y,z = 0;
        try{
            Scanner sc=new Scanner(System.in);
            x= sc.nextInt(); y=sc.nextInt();
            z=x/y;

            System.out.println("Quotient: "+z);
        }
        // we can write a try block without catch and finally
        catch (ArithmeticException e){
            System.out.println("Can't  divide by zero, setting z to max value");
            z=Integer.MAX_VALUE;
        }
        catch (InputMismatchException e){
            System.out.println("Input should be an integer");
        }
        catch (Exception e) {
            System.out.println("Some error occurred: " + e);
        }
        // in websites, finally is used to close all the connections being opened
        finally {
            System.out.println("All done");
        }
        System.out.println("Z: "+z);
    }
}
