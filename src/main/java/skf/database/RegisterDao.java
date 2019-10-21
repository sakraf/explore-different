package skf.database;

import skf.bean.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao {

    public int registerCustomer(Customer customer) {
        String INSERT_USERS_SQL = "INSERT INTO customer" +
                "  (first_name, last_name, username, password, address, contact) VALUES " +
                " (?, ?, ?, ?,?,?);";


        int result = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/project_db?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", null);

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.setString(3, customer.getUsername());
            preparedStatement.setString(4, customer.getPassword());
            preparedStatement.setString(5, customer.getAddress());
            preparedStatement.setString(6, customer.getContact());

            System.out.println(preparedStatement);

            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            printSQLException(e);
        }

        String INSERT_LOGIN_SQL = "INSERT INTO login" + "(username, password) VALUES" + "(?, ?);";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/project_db?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", null);
             PreparedStatement updateLogin = connection.prepareStatement(INSERT_LOGIN_SQL)) {
            updateLogin.setString(1,customer.getUsername());
            updateLogin.setString(2, customer.getPassword());

            updateLogin.executeUpdate();

        } catch (SQLException e) {
            printSQLException(e);
        }

        return result;

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
