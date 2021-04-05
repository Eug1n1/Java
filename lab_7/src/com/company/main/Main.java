package com.company.main;

import com.company.dbClass.MyDBClass;
import com.company.tests.TestPack;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, IOException, InstantiationException, SQLException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        Result result = JUnitCore.runClasses(TestPack.class);

        for (Failure failure:result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }
}
