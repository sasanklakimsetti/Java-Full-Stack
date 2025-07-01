package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {
    String vehicleType;
    String regNo;
    String color;
    String company;
    String model;
    Customer customer;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Vehicle(String vehicleType, String regNo, String color, String company, String model, Customer customer){
        this.vehicleType=vehicleType;
        this.regNo=regNo;
        this.color=color;
        this.company=company;
        this.model=model;
        this.customer=customer;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract double getParkingFee();
}