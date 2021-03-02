package com.company.main;

import com.company.Xml.CarXMLSerializer;
import com.company.vehicle.EngineType;
import com.company.vehicle.FreightCar;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        try
        {
            FreightCar a = new FreightCar("bakd", EngineType.electricEngine, 2, 10, 10 ,5 ,10);
            a.introduce();
            File file = new File("/home/eug1n1/1.xml");

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(CarXMLSerializer.Serialize(a), new StreamResult(file));
        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }finally {
            System.out.println("finally");
        }
    }
}
