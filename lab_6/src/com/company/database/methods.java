package com.company.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public interface methods {
    void getBooksByYear(int year) throws SQLException;
    void getAuthors() throws SQLException;
    void deleteByYear(int year) throws SQLException;
    Connection getConnection(String path) throws IOException, SQLException;
}
