package com.summerpep.model;

import jakarta.persistence.*;

@Entity
public class Hostel {
    @TableGenerator(name = "allidtable", allocationSize = 1, initialValue = 20)
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "allidtable")
    int hostelid;
    String name;

    @Override
    public String toString() {
        return "Hostel{" +
                "hostelid=" + hostelid +
                ", name='" + name + '\'' +
                '}';
    }

    public int getHostelid() {
        return hostelid;
    }

    public void setHostelid(int hostelid) {
        this.hostelid = hostelid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
