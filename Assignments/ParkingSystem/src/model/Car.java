package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Car extends Vehicle{
    String carType;
    static final Map<String, Double>fares=Map.of(
            "SUV",120.0,
            "Coupe",110.0,
            "Sedan",100.0,
            "Hatchback",80.0
    );



    public Car(String regNo, String color, String company, String model, String carType, Customer customer) {
        super("Car", regNo, color, company, model, customer);
        this.carType = carType;
    }
    public double getParkingFee(){
        return fares.getOrDefault(carType,100.0);
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }
}
