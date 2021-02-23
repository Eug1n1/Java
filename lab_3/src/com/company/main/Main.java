package com.company.main;

import com.company.vehicle.EngineType;
import com.company.vehicle.FreightCar;

public class Main {

    public static void main(String[] args) {
        FreightCar a = new FreightCar("bakd", EngineType.electricEngine, 2, 10, 10 ,10 ,10);
        a.introduce();
    }
}
