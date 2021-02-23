package com.company.vehiclestation;

import com.company.vehicle.Car;

import java.util.ArrayList;

public class VehicleStation{

    private ArrayList<Car> carList;

    public VehicleStation(){
    }

    public VehicleStation(ArrayList<Car> carList) {
        this.carList = carList;
    }

    public ArrayList<Car> getCarList() {
        return carList;
    }

    public void setCarList(ArrayList<Car> carList) {
        this.carList = carList;
    }

    public boolean add(Car car) throws Exception {
        if(car == null)
            throw new Exception();

        return carList.add(car);
    }

    public boolean remove(Car car) throws Exception{
        if(car == null)
            throw new Exception();

        return carList.remove(car);
    }

    @Override
    public String toString() {
        return "VehicleStation{" +
                "carList=" + carList +
                '}';
    }
}
