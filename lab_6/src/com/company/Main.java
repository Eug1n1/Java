package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;

public class Main {

    static Connection conn;
    static Statement statement;

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

        conn = getConnection();
        statement = conn.createStatement();

        deleteByYear(1999);

    }

    public static void getBooksByYear(String condition) throws Exception {
        ResultSet result = statement.executeQuery("select * from BOOKS where year(BOOKS.year) " + condition);

        while (result.next()) {
            String title = result.getString(1);
            String author = result.getString(2);
            Date date = result.getDate(3);
            String publisher = result.getString(4);

            System.out.printf("%s  %s  %s  %s\n", title, author, date.toString(), publisher);
        }
    }

    public static void getAuthors() throws SQLException {
        ResultSet result = statement.executeQuery("select * from AUTHORS");

        while (result.next()) {
            int id = result.getInt(1);
            String name = result.getString(2);
            String country = result.getString(3);

            System.out.printf("%d  %s  %s\n", id, name, country);
        }
    }

    public static void deleteByYear(int year) throws SQLException {
        int rows = statement.executeUpdate("DELETE FROM BOOKS WHERE year(BOOKS.year) > " + year);
        System.out.printf("%d row(s) deleted", rows);
    }

    public static Connection getConnection() throws SQLException, IOException {

        Properties props = new Properties();
        try(InputStream in = Files.newInputStream(Paths.get("/home/eug1n1/Java/lab_6/prop/database.properties"))) {
            props.load(in);
        }
        String url = props.getProperty("url");
        String username = props.getProperty("username");
        String password = props.getProperty("password");

        return DriverManager.getConnection(url, username, password);
    }
}
