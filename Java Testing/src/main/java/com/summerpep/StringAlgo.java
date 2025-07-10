package com.summerpep;

public class StringAlgo {
    public static String shift2Chars(String str){
        // write algo to return hello to ellho
        // programming -> ogrammingpr

        // what if length < 2
        // what if the length == 2 i.e. boundary values
        if(str.length()==2) return str;
        if(str.length()<2) return str;
        String sub=str.substring(0,2);
        String sub2=str.substring(2,str.length());
        return sub2+sub;
    }
    public static void main(String[] args){
        System.out.println(shift2Chars("Sasank"));
        System.out.println(shift2Chars("a1")); // boundary values
        System.out.println(shift2Chars("a")); // throws IndexOutOfBound exception
    }
}
