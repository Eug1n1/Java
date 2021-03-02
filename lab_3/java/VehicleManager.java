package com.company.vehiclemanager;

import com.company.vehicle.Car;
import com.company.vehiclestation.VehicleStation;

public class VehicleManager {

    private VehicleStation station;

    public VehicleManager(VehicleStation station) {
        this.station = station;
    }

    public int countPrice(){
        int totalPrice = 0;
        for (Car car:station.getCarList()) {
            totalPrice += car.getPrice();
        }

        return totalPrice;
    }

    public void sort(){
       station.getCarList().sort(new Comparator<Car>() {
           public int compare(Car o1, Car o2) {
               return Integer.compare(o1.getConsumption(), o2.getConsumption());
           }
       });
    }

    public ArrayList<Car> findCars(int startSpeed, int endSpeed){
        ArrayList<Car> cars = new ArrayList<Car>();

        for (Car car:station.getCarList()){
            if(car.getSpeed() >= startSpeed && car.getSpeed() <= endSpeed){
                cars.add(car);
            }
        }

        return cars;
    }

    public VehicleStation getStation() {
        return station;
    }

    public void setStation(VehicleStation station) {
        this.station = station;
    }
}
