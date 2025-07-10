package com.summerpep.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("faculty")
public class Faculty extends Person {

    Integer facid;
    String designation;

    public Faculty() {
    }

    public Faculty(Integer facid, String designation) {
        this.facid = facid;
        this.designation = designation;
    }

    public Faculty(Integer pid, String name, String phone, Integer facid, String designation) {
        super(pid, name, phone);
        this.facid = facid;
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facid=" + facid +
                ", designation='" + designation + '\'' +
                '}';
    }

    public int getFacid() {
        return facid;
    }

    public void setFacid(Integer facid) {
        this.facid = facid;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
