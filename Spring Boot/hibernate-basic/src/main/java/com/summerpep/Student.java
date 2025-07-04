package com.summerpep;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Student {
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
                "rollno=" + rollno +
                ", sname='" + sname + '\'' +
                ", branch='" + branch + '\'' +
                ", mobileno='" + mobileno + '\'' +
                ", dob=" + dob +
                ", marks=" + marks +
                ", gender=" + gender +
                '}';
    }
    public Student(String sname, String branch, String mobileno, Date dob, Integer marks, Gender gender) {
        this.sname = sname;
        this.branch = branch;
        this.mobileno = mobileno;
        this.dob = dob;
        this.marks = marks;
        this.gender = gender;
    }
    // in hibernate, we must create a default constructor if we create any parameterized constructor.
    // otherwise, hibernate won't work
    // we don't need to create default constructor if we don't have any parameterized constructor
    public Student() {
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Integer getMarks() {
        return marks;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
