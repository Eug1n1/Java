package com.company.vehicle;

public class PassengerCar extends Car{
    public PassengerCar() {
    }

    public PassengerCar(String model, EngineType engineType, int consumption, int maxSpeed, int weight, int speed, int price) throws Exception {
        super(model, engineType, consumption, maxSpeed, weight, speed, price);
    }

    @Override
    public void introduce() {
        System.out.println("#### Passenger car ####");
        super.introduce();
    }
}
