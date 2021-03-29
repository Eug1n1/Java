package com.company.dbClass;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Properties;
import java.sql.*;

public class MyDBClass {

    Connection conn;
    Statement statement;

    public MyDBClass(String path) throws IOException, SQLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

        conn = getConnection(path);
        statement = conn.createStatement();
    }

    public ArrayList<String> getBooksByYear(int year) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("select * from BOOKS WHERE year(BOOKS.year) > ?");
        preparedStatement.setInt(1, year);
        ResultSet result = preparedStatement.executeQuery();

        ArrayList<String> books = new ArrayList<String>();

        while (result.next()) {
            String title = result.getString(1);
            String author = result.getString(2);
            Date date = result.getDate(3);
            String publisher = result.getString(4);

            books.add(String.format("%s %s %s %s", title, author, date.toString(), publisher));
        }
        result.close();

        return books;
    }

    public ArrayList<String> getAuthors() throws SQLException {
        ResultSet result = statement.executeQuery("select * from AUTHORS");
        ArrayList<String> authors = new ArrayList<String>();

        while (result.next()) {
            int id = result.getInt(1);
            String name = result.getString(2);
            String country = result.getString(3);

            authors.add(String.format("%d %s %s", id, name, country));
        }
        result.close();

        return authors;
    }

    public String deleteByYear(int year) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM BOOKS WHERE year(BOOKS.year) > ?");
        preparedStatement.setInt(1, year);
        int rows = preparedStatement.executeUpdate();

        return String.format("%d row(s) deleted", rows);
    }

    public Connection getConnection(String path) throws IOException, SQLException {
        Properties props = new Properties();
        try(InputStream in = Files.newInputStream(Paths.get(path))) {
            props.load(in);
        }
        String url = props.getProperty("url");
        String username = props.getProperty("username");
        String password = props.getProperty("password");

        return DriverManager.getConnection(url, username, password);
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }
}
