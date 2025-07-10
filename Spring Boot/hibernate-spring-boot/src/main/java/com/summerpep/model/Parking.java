package com.summerpep.model;

import jakarta.persistence.*;

@Entity
public class Parking {
    @SequenceGenerator(name = "parkingidseq", initialValue = 1101, allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parkingidseq")
    int parkingid;
    Integer floor, place;

    // @JoinColumn(name="empid) // if not given, employee_empid will be column
    @OneToOne(fetch = FetchType.EAGER)
    Employee employee;

    public int getParkingid() {
        return parkingid;
    }

    public void setParkingid(int parkingid) {
        this.parkingid = parkingid;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Parking{" +
                "parkingid=" + parkingid +
                ", floor=" + floor +
                ", place=" + place +
                ", employee=" + employee +
                '}';
    }
}
