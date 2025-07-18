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

    public Student(){
    }
    public Student(int rollno, String sname, String branch, String mobileno, Date dob, Integer marks, Gender gender) {
        this.rollno=rollno;
        this.sname = sname;
        this.branch = branch;
        this.mobileno = mobileno;
        this.dob = dob;
        this.marks = marks;
        this.gender = gender;
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
