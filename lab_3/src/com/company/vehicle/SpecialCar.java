package com.company.vehicle;

public class SpecialCar extends Car {
    public SpecialCar() {
    }

    public SpecialCar(String model, EngineType engineType, int consumption,
                      int maxSpeed, int weight, int speed, int price) throws Exception {
        super(model, engineType, consumption, maxSpeed, weight, speed, price);
    }

    @Override
    public void introduce() {
        System.out.println("#### Special car ####");
        super.introduce();
    }
}
