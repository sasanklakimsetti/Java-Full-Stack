package com.summerpep.algo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(value = "singleton") //default
//@Scope("prototype") // create new object every time asked for
//@Scope("request") // will create new object for every request
//@Scope("session") // for user session create new object
@Scope("application")
//@Scope()
public class MyService {
    PasswordHasher myNextPasswordHasher;
    PasswordHasher passwordHasher;

    public MyService() {
    }

    public MyService(PasswordHasher myNextPasswordHasher, PasswordHasher passwordHasher) {
        this.myNextPasswordHasher = myNextPasswordHasher;
        this.passwordHasher = passwordHasher;
    }

    public PasswordHasher getMyNextPasswordHasher() {
        return myNextPasswordHasher;
    }

    public void setMyNextPasswordHasher(PasswordHasher myNextPasswordHasher) {
        this.myNextPasswordHasher = myNextPasswordHasher;
    }

    public PasswordHasher getPasswordHasher() {
        return passwordHasher;
    }

    public void setPasswordHasher(PasswordHasher passwordHasher) {
        this.passwordHasher = passwordHasher;
    }

    public void show(){
        System.out.println("hashers = "+myNextPasswordHasher+" and "+passwordHasher);
    }
}
