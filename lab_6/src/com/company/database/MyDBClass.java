package com.company.database;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.sql.*;

public class MyDBClass implements methods {

    Connection conn;
    Statement statement;

    public MyDBClass(String path) throws IOException, SQLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

        conn = getConnection(path);
        statement = conn.createStatement();
    }

    @Override
    public void getBooksByYear(int year) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("select * from BOOKS WHERE year(BOOKS.year) > ?");
        preparedStatement.setInt(1, year);
        ResultSet result = preparedStatement.executeQuery();
        while (result.next()) {
            String title = result.getString(1);
            String author = result.getString(2);
            Date date = result.getDate(3);
            String publisher = result.getString(4);

            System.out.printf("%s  %s  %s  %s\n", title, author, date.toString(), publisher);
        }
        result.close();
    }

    @Override
    public void getAuthors() throws SQLException {
        ResultSet result = statement.executeQuery("select * from AUTHORS");

        while (result.next()) {
            int id = result.getInt(1);
            String name = result.getString(2);
            String country = result.getString(3);

            System.out.printf("%d  %s  %s\n", id, name, country);
        }
        result.close();
    }

    @Override
    public void deleteByYear(int year) throws SQLException {
        conn.setAutoCommit(false);
        Savepoint savepointOne = conn.setSavepoint("SavepointOne");
        int rows = 0;
        try
        {
            PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM BOOKS WHERE year(BOOKS.year) > ?");
            preparedStatement.setInt(1, year);
            rows = preparedStatement.executeUpdate();
            throw new Exception();
        }
        catch (Exception e)
        {
            conn.rollback(savepointOne);
        }
        conn.commit();
        System.out.printf("%d row(s) deleted\n", rows);
        conn.setAutoCommit(true);
    }

    @Override
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
}
