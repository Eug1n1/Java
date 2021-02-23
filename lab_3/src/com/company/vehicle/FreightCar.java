package com.company.vehicle;

public class FreightCar extends Car {
    public FreightCar() {
    }

    public FreightCar(String model, EngineType engineType, int consumption, int maxSpeed, int weight, int speed, int price) {
        super(model, engineType, consumption, maxSpeed, weight, speed, price);
    }

    @Override
    public void introduce() {
        System.out.println("#### Freight car ####");
        super.introduce();
    }
}
