package com.company.vehicle;

public class PassengerCar extends Car{
    public PassengerCar() {
    }

    public PassengerCar(String model, int maxSpeed, int weight, int speed, int price) {
        super(model, maxSpeed, weight, speed, price);
    }

    @Override
    public void introduce() {
        System.out.println("#### Passenger car ####");
        super.introduce();
    }
}
