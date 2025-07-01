package model;

public class Truck extends Vehicle{
    public Truck(String regNo, String color, String company, String model, Customer customer) {
        super("Truck", regNo, color, company, model, customer);
    }

    @Override
    public double getParkingFee() {
        return 180;
    }
}