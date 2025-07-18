package com.summerpep.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "users")
public class User {
    @Id
    String username;
    String fname;
    String lname;
    String mobile;
    String mail;
    String address;
    @Column(name = "dob")
    Date dob;
    String password;
    String cnfrmPassword;

    @Override
    public String toString() {
        return "User{" +
                "username=" + username +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", mobile='" + mobile + '\'' +
                ", mail='" + mail + '\'' +
                ", address='" + address + '\'' +
                ", dob=" + dob +
                ", password='" + password + '\'' +
                ", cnfrmPassword='" + cnfrmPassword + '\'' +
                '}';
    }

    public User() {
    }

    public User(String fname, String lname, String mobile, String mail, String address, Date dob, String password, String cnfrmPassword) {
        this.username = username;
        this.fname = fname;
        this.lname = lname;
        this.mobile = mobile;
        this.mail = mail;
        this.address = address;
        this.dob = dob;
        this.password = password;
        this.cnfrmPassword = cnfrmPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCnfrmPassword() {
        return cnfrmPassword;
    }

    public void setCnfrmPassword(String cnfrmPassword) {
        this.cnfrmPassword = cnfrmPassword;
    }
}
