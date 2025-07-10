package com.summerpep.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Department {
    @SequenceGenerator(name = "depidseq", initialValue = 501, allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int depid;
    String name;

    // mappedBy = Name of data member in the target class for this class
    @OneToMany (mappedBy = "department")
    Set<Employee> employees=new HashSet<>();

    public int getDepid() {
        return depid;
    }

    public void setDepid(int depid) {
        this.depid = depid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Department() {
    }

    public Department(int depid, String name, Set<Employee> employees) {
        this.depid = depid;
        this.name = name;
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "depid=" + depid +
                ", name='" + name + '\'' +
                ", employees=" + employees +
                '}';
    }
}
