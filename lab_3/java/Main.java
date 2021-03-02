package com.company.main;

import com.company.vehicle.*;
import com.company.vehiclemanager.VehicleManager;
import com.company.vehiclestation.VehicleStation;

public class Main {

    public static void main(String[] args) {
        try
        {
            FreightCar a = new FreightCar("FreightCar1", EngineType.petrolEngine, 4, 150, 9873 ,5 ,120);
            FreightCar aa = new FreightCar("FreightCar2", EngineType.electricEngine, 8, 100, 1233 ,5 ,120);
            FreightCar aaa = new FreightCar("FreightCar3", EngineType.dieselEngine, 12, 70, 34552,5 ,120);
            SpecialCar b = new SpecialCar("SpecialCar1", EngineType.petrolEngine, 5, 100, 12310 ,5 ,100);
            SpecialCar bb = new SpecialCar("SpecialCar2", EngineType.dieselEngine, 10, 80, 9832 ,5 ,100);
            SpecialCar bbb = new SpecialCar("SpecialCar3", EngineType.electricEngine, 15, 15, 45000 ,5 ,100);
            PassengerCar c = new PassengerCar("PassengerCar1", EngineType.electricEngine, 2, 180, 2000 ,56 ,567);
            PassengerCar cc = new PassengerCar("PassengerCar2", EngineType.petrolEngine, 4, 110, 3000 ,52 ,98765);
            PassengerCar ccc = new PassengerCar("PassengerCar3", EngineType.electricEngine, 6, 280, 1000 ,89 ,5673);


            VehicleStation st = new VehicleStation();
            st.add(a);
            st.add(aa);
            st.add(aaa);
            st.add(b);
            st.add(bb);
            st.add(bbb);
            st.add(c);
            st.add(cc);
            st.add(ccc);

            VehicleManager m = new VehicleManager(st);

//            File file = new File("files/1.xml");
//
//            st.saveToXML("files/1.xml");
//            VehicleStation sta = new VehicleStation();
//            sta.loadFromXML("files/1.xml");


//            SchemaFactory factory =
//                    SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
//
//            File schemaLocation = new File("files/1.xsd");
//            Schema schema = factory.newSchema(schemaLocation);
//
//            Validator validator = schema.newValidator();
//
//            Source source = new StreamSource("files/1.xml");
//
//            try {
//                validator.validate(source);
//                System.out.println("1.xml is valid.");
//            }
//            catch (SAXException ex) {
//                System.out.println("1.xml is not valid because ");
//                System.out.println(ex.getMessage());
//            }

//            for (Car car:((VehicleStation) sta).getCarList()) {
//                System.out.println(car.getModel());
//            }
//            ObjectMapper mapper = new ObjectMapper();
//            mapper.writeValue(new File("files/2.json"), st);
//            VehicleStation sta = mapper.readValue(new File("files/2.json"), VehicleStation.class);

            System.out.println(st.getCarList().stream().count());

            for (Object car : st.getCarList().stream().filter(x -> x.getMaxSpeed() > 100).toArray()) {
                System.out.println(((Car) car).getModel());
            }
//            for (Car car : sta.getCarList()) {
//                System.out.println(car.getModel());
//            }


        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }finally {
            System.out.println("finally");
        }
    }
}
