package com.company.tests;

import com.company.dbClass.MyDBClass;
import org.junit.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBClassTests {

    static MyDBClass myDb;

    @BeforeClass
    public static void setUp() throws NoSuchMethodException, IOException, InstantiationException, SQLException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        myDb = new MyDBClass("/home/eug1n1/Java/lab_6/prop/database.properties");
    }

    @AfterClass
    public static void close() throws SQLException {
        myDb.closeConnection();
    }

    @After
    public void afterMethod() {
        System.out.println("Code executes after each test method");
    }

    @Test
    public void getBooksByYearTest() throws NoSuchMethodException, IOException, InstantiationException, SQLException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        ArrayList<String> books = myDb.getBooksByYear(1990);

        ArrayList<String> expBooks = new ArrayList<String>();
        expBooks.add("Sergey Pirogov Tihamey pihimey 1996-12-25 Zheltoe derevo");
        expBooks.add("Vidday salo Pchelko Bjilkin 1994-01-04 Smachne saltse");

        Assert.assertEquals(books, expBooks);
    }

    @Test(timeout = 100)
    public void getAuthorsTest() throws NoSuchMethodException, IOException, InstantiationException, SQLException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        ArrayList<String> authors = myDb.getAuthors();

        ArrayList<String> expAuthors = new ArrayList<String>();
        expAuthors.add("1 Karas Bulba Belarus");
        expAuthors.add("2 Pingvini Kowalski Poland");
        expAuthors.add("3 Saltse Bjilkin Ukrain");
        expAuthors.add("4 Tihamey pihimey Russian");

        Assert.assertEquals(expAuthors, authors);
    }

    @Ignore
    @Test
    public void deleteByYearTest() throws SQLException, NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        String str = myDb.deleteByYear(2020);

        String expString = "0 row(s) deleted";

        Assert.assertEquals(expString, str);
    }
}

