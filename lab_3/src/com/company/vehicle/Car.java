package com.company.vehicle;

public abstract class Car implements Vehicle {

    private String model;
    private int maxSpeed;
    private int weight;
    private int speed;
    private int price;
    private int consumption;
    private EngineType engineType;
    private Owner owner;

    @Override
    public void introduce() {
        System.out.println("Model: " + model);
        System.out.println("Engine type: " + engineType.toString());
        System.out.println("Weight: " + weight);
        System.out.println("speed: " + speed);
        System.out.println("Max speed: " + maxSpeed);
    }

    public Car(){}

    public Car(String model, EngineType engineType, int consumption, int maxSpeed, int weight, int speed, int price) {
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.speed = speed;
        this.price = price;
        this.engineType = engineType;
        this.consumption = consumption;
        owner = new Owner("Eugene", "I", "0.1");
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

    public int getConsumption() {
        return consumption;
    }

    public void setConsumption(int consumption) {
        this.consumption = consumption;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    public Owner getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", speed=" + speed +
                '}';
    }

    class Owner{
        public String name;
        public String company;
        public String version;

        public Owner(String name, String company, String version) {
            this.name = name;
            this.company = company;
            this.version = version;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }
    }
}
