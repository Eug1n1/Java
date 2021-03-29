package com.company.main;

import com.company.dbClass.MyDBClass;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, IOException, InstantiationException, SQLException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        MyDBClass myDb = new MyDBClass("/home/eug1n1/Java/lab_6/prop/database.properties");
        ArrayList<String> books = myDb.getAuthors();

        for (String str: books) {
            System.out.println(str);
        }
    }
}
