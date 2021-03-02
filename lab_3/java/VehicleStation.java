package com.company.vehiclestation;

import com.company.vehicle.Car;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class VehicleStation{

    private ArrayList<Car> carList;

    public VehicleStation(){
        carList = new ArrayList<Car>();
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

        carList.add(car);

        return true;
    }

    public boolean remove(Car car) throws Exception{
        if(car == null)
            throw new Exception();

        return carList.remove(car);
    }

    public void saveToXML(String path) throws Exception{
        File file = new File(path);

        XMLEncoder encoder = new XMLEncoder(new FileOutputStream(file));
        encoder.writeObject(carList);
        encoder.flush();
        encoder.close();
    }

    public void loadFromXML(String path) throws Exception {
        File file = new File(path);

        XMLDecoder decoder = new XMLDecoder(new FileInputStream(file));
        carList = (ArrayList<Car>)decoder.readObject();
        decoder.close();
    }

    public void saveToJson(String path) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(path), carList);
    }

    public void loadFromJson(String path) throws Exception {

    }

    @Override
    public String toString() {
        return "VehicleStation{" +
                "carList=" + carList +
                '}';
    }
}
