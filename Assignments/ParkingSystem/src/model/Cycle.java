package model;

public class Cycle extends Vehicle{
    public Cycle(String regNo, String color, String company, String model, Customer customer) {
        super("Cycle", regNo, color, company, model, customer);
    }

    @Override
    public double getParkingFee() {
        return 20;
    }
}