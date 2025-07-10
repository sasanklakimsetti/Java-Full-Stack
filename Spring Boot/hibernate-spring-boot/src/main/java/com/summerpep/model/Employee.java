package com.summerpep.model;

import jakarta.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    int empid;
    String name, designation;

    // Employee     Many in One     Department
    @ManyToOne
    @JoinColumn(name = "depid")
    Department department;
    Integer mgrid;

    public Employee() {
    }

    public Employee(int empid, String name, String designation, Department department, Integer mgrid) {
        this.empid = empid;
        this.name = name;
        this.designation = designation;
        this.department = department;
        this.mgrid = mgrid;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empid=" + empid +
                ", name='" + name + '\'' +
                ", designation='" + designation + '\'' +
                ", department=" + department +
                ", mgrid=" + mgrid +
                '}';
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getMgrid() {
        return mgrid;
    }

    public void setMgrid(Integer mgrid) {
        this.mgrid = mgrid;
    }
}
