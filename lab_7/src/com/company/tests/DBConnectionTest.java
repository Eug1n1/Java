package com.company.tests;

import com.company.dbClass.MyDBClass;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class DBConnectionTest {

    @Test
    public void connectionTest() throws NoSuchMethodException, IOException, InstantiationException, SQLException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        MyDBClass myDb = new MyDBClass("/home/eug1n1/Java/lab_6/prop/database.properties");

        Assert.assertNotNull(myDb.getConnection("/home/eug1n1/Java/lab_6/prop/database.properties"));
    }

}
