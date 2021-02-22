package com.company.vehicle;

public abstract class Car implements Vehicle {

    public String model;
    public int maxSpeed;
    public int weight;
    public int speed;
    public int price;

    @Override
    public void introduce() {
        System.out.println("Model: " + model);
        System.out.println("Weight: " + weight);
        System.out.println("speed: " + speed);
        System.out.println("Max speed: " + maxSpeed);
    }

    public Car(){}

    public Car(String model, int maxSpeed, int weight, int speed, int price) {
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.speed = speed;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", speed=" + speed +
                '}';
    }
}
