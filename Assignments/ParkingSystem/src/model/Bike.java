package model;

public class Bike extends Vehicle{
    Customer customer;
    public Bike(String regNo, String color, String company, String model, Customer customer) {
        super("Bike", regNo, color, company, model, customer);
    }

    @Override
    public double getParkingFee() {
        return 60;
    }
}
