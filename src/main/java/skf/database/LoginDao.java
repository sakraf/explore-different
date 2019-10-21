package skf.database;

import skf.bean.Login;

import java.sql.*;

public class LoginDao {

    public Integer validate(Login loginBean) throws ClassNotFoundException {
        Integer userId = null;

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/project_db?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root",null);

             // Step 2:Create a statement using connection objects
             PreparedStatement preparedStatement = connection
                     .prepareStatement("select * from customer where username = ? and password = ? ")) {
            preparedStatement.setString(1, loginBean.getUsername());
            preparedStatement.setString(2, loginBean.getPassword());


            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()){
                userId = rs.getInt(1);

            }

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return userId;
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