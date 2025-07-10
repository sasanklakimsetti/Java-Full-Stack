package com.summerpep.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("student")
public class Student2 extends Person{
    Integer roll;
    String branch;

    public Student2() {
    }

    public Student2(Integer roll, String branch) {
        this.roll = roll;
        this.branch = branch;
    }

    public Student2(Integer pid, String name, String phone, Integer roll, String branch) {
        super(pid, name, phone);
        this.roll = roll;
        this.branch = branch;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(Integer roll) {
        this.roll = roll;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "roll=" + roll +
                ", branch='" + branch + '\'' +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
