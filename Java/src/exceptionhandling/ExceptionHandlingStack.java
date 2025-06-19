package exceptionhandling;

import java.util.ArrayList;

class OverFlowException extends Exception{
    String msg;
    public OverFlowException(String msg){
        this.msg=msg;
    }
    public String toString(){
        return msg;
    }
}
class UnderFlowException extends Exception{
    String msg;
    public UnderFlowException(String msg){
        this.msg = msg;

    }

    public String toString(){
        return msg;
    }

}
class Stack{
    int[] arr;
    int n;
    int topPointer;
    public Stack(int n){
        this.n=n;
        arr=new int[n];
        topPointer=-1;
    }
    public void push(int x) throws OverFlowException{
        if(topPointer==n-1) throw new OverFlowException("Stack is full");
        arr[topPointer+1]=x;
        topPointer++;
    }
    public int pop() throws UnderFlowException {
        if(topPointer==-1) throw new UnderFlowException("Stack is empty");
        int ele=arr[topPointer];
        topPointer--;
        return ele;
    }
}
public class ExceptionHandlingStack {
    public static void main(String[] args){
        Stack s1=new Stack(10);
        try {
            System.out.println(s1.pop());
        } catch (UnderFlowException e) {
            System.out.println(e);
        }
        try{
            s1.push(1);
        }
        catch (OverFlowException e){
            System.out.println(e);
        }
    }
}
