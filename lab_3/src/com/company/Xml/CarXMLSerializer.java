package com.company.Xml;

import com.company.vehicle.Car;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;

public class CarXMLSerializer {

    private static DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

    public static DOMSource Serialize(Car car) {

        factory.setNamespaceAware(true);
        try {
            Document doc = factory.newDocumentBuilder().newDocument();
            Element root = doc.createElement("Car");
            doc.appendChild(root);

            Element model = doc.createElement("Model");
            model.setTextContent(car.getModel());
            root.appendChild(model);

            Element engine = doc.createElement("Engine_type");
            engine.setTextContent(car.getEngineType().toString());
            root.appendChild(engine);

            Element weight = doc.createElement("Weight");
            weight.setTextContent(String.valueOf(car.getWeight()));
            root.appendChild(weight);

            Element speed = doc.createElement("Speed");
            speed.setTextContent(String.valueOf(car.getSpeed()));
            root.appendChild(speed);

            Element maxSpeed = doc.createElement("Max_speed");
            maxSpeed.setTextContent(String.valueOf(car.getMaxSpeed()));
            root.appendChild(maxSpeed);

            return new DOMSource(doc);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }

}
