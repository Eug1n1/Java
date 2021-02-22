package com.company.vehicle;

public class SpecialCar extends Car {
    public SpecialCar() {
    }

    public SpecialCar(String model, int maxSpeed, int weight, int speed, int price) {
        super(model, maxSpeed, weight, speed, price);
    }

    @Override
    public void introduce() {
        System.out.println("#### Special car ####");
        super.introduce();
    }
}
