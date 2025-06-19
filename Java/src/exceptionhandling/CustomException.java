package exceptionhandling;

import java.util.Scanner;

class BigNumberException extends Exception{
    int num;
    String msg;
    public BigNumberException(String msg){
        super(msg);
        this.msg=msg;
    }
    // overloading the parameterized constructor
    public BigNumberException(String msg , int num){
        // the super(msg) will call the constructor which is already defined in in-built Exception class
        // this will be useful to have custom message for each case of  the same exception
        // instead of writing exception message for every case
        this.num = num;
        this.msg = msg;
    }
    // overriding the toString() method in Object class. Whatever constructor we call, this will only be executed.
    // this is used so that we can display only the message. Not the exception type.
    // In normal toString() method, it will display the exception type as well.
    public String toString(){
        String errorMessage = msg + " You have entered "+num;
        return errorMessage;
    }
}
public class CustomException {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int x=0,y=0,z=0;
        try{
            System.out.println("Enter in the range of 1 to 1000");
            x=sc.nextInt();
            if(x>1000) throw new BigNumberException("Should be less than or equal to 1000" , x);
            else if(x<0) throw new BigNumberException("Should be greater than 0");
            y=sc.nextInt();
            if(y>1000) throw new BigNumberException("Should be within 1 to 1000",y);
            else if(y<0) throw new BigNumberException("Should be greater than 0");
            z=x/y;
        }
        catch (BigNumberException e){
            System.out.println(e);
        }
        catch (ArithmeticException e){
            System.out.println("Divison not possible with zero");
        }
        catch (Exception e){
            System.out.println(e);
        }

    }
}
