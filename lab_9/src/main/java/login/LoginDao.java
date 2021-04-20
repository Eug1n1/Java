package login;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class LoginDao {

    public boolean insert(LoginBean loginBean) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        int rs = 0;
        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/java?useSSL=false", "root", "Pass-123");

             PreparedStatement preparedStatement = connection
                     .prepareStatement("insert into users values (?, ?, ?)")) {
            preparedStatement.setString(1, loginBean.getUsername());
            preparedStatement.setString(2, loginBean.getPassword());
            preparedStatement.setString(3, loginBean.getRole());

            rs = preparedStatement.executeUpdate();

        }catch (SQLException e) {
            printSQLException(e);
        }

        return rs == 1;
    }

    public boolean validate(LoginBean loginBean) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        boolean status = false;

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/java?useSSL=false", "root", "Pass-123");

             PreparedStatement preparedStatement = connection
                     .prepareStatement("select * from users where username = ? and password = ? ")) {
            preparedStatement.setString(1, loginBean.getUsername());
            preparedStatement.setString(2, loginBean.getPassword());

            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();

        } catch (SQLException e) {
            printSQLException(e);
        }
        return status;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }


}
