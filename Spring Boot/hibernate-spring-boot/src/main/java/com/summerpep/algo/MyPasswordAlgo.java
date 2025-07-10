package com.summerpep.algo;

import org.springframework.stereotype.Component;

// Component: We are saying Spring that we want an object of this class
@Component
public class MyPasswordAlgo {
    public String encrypt(String password){
        // write a program to reverse a string
        StringBuilder sb=new StringBuilder(password);
        StringBuilder reverse=sb.reverse();
        return reverse.toString();
    }
}
