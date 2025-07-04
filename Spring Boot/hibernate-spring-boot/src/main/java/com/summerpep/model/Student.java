package com.summerpep.model;

import jakarta.persistence.*;

import java.util.Date;

// Entity means this class is associated with some table in the database
@Entity
public class Student {
    // Id means identity i.e. primary key in sql
    // Without Id, hibernate doesn't work at all
    @Id
    int rollno;
    String sname;
    String branch;
    String mobileno;
    Date dob;
    Integer marks;

    public enum Gender {
        male, female
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    Gender gender;

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollno +
                ", sname='" + sname + '\'' +
                ", branch='" + branch + '\'' +
                ", mobileNo='" + mobileno + '\'' +
                ", dob=" + dob +
                ", marks=" + marks +
                ", gender=" + gender +
                '}';
    }
}
