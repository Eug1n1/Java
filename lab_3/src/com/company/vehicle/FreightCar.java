package com.company.vehicle;

public class FreightCar extends Car {

    public FreightCar(String model, int maxSpeed, int weight, int speed, int price) {
        super(model, maxSpeed, weight, speed, price);
    }

    @Override
    public void introduce() {
        System.out.println("#### Freight car ####");
        super.introduce();
    }
}
