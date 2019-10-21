package skf.controller;

import skf.bean.Bike;
import skf.bean.Customer;

import java.sql.*;
import java.util.ArrayList;

public class SQLControl {

    Connection con = null;
    Statement st = null;
    ResultSet rs = null;


    public SQLControl(){
    }

    public void loadDB() {
        try {
            con = DBContext.getConnection();
            st = con.createStatement();
        } catch (Exception ex) {
            System.out.println("Cant load DB");
        }

    }


    public ArrayList<Bike> selectAllProduct() throws SQLException, ClassNotFoundException {
        ArrayList<Bike> pArrList = new ArrayList<>();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/project_db?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root",null);
        PreparedStatement preparedStatement = null;
        ResultSet statementSelectRs = null;
        try{
             preparedStatement = connection
                     .prepareStatement("SELECT * FROM ProductTBL");

            statementSelectRs = preparedStatement.executeQuery();
            while (statementSelectRs.next()) {
                String bikeId = statementSelectRs.getString("ProductID");
                String bikeName = statementSelectRs.getString("ProductName");
                int bikePrice = Integer.parseInt(statementSelectRs.getString("ProductPrice"));
                String imageUrl = statementSelectRs.getString("ImageURL");
                pArrList.add(new Bike(bikeId, bikeName, bikePrice, imageUrl));
            }

        } catch (SQLException ex) {
            System.out.println("SQL Error");
        } finally {
            statementSelectRs.close();
            preparedStatement.close();
            connection.close();
        }
        return pArrList;
    }


    public ArrayList<Bike> selectProduct(String id) throws SQLException, ClassNotFoundException {
        System.out.println(id);

        ArrayList<Bike> arrCart = new ArrayList<>();
        String xSQL = "select * from ProductTBL where ProductID = '" + id + "'" ;
        Statement st;
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/project_db?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root",null);
        //PreparedStatement preparedStatement = null;
       // ResultSet statementSelectRs = null;
        ResultSet statementSelectRs = null;
        st = connection.createStatement();
        try{
           //  preparedStatement = connection
           //          .prepareStatement("SELECT * FROM ProductTBL WHERE ProductID = " + id + " LIMIT 1");
            statementSelectRs = st.executeQuery(xSQL);
         //   statementSelectRs = preparedStatement.executeQuery();
            while (statementSelectRs.next()) {
                String bikeId = statementSelectRs.getString("ProductID");
                System.out.println(bikeId);
                String bikeName = statementSelectRs.getString("ProductName");
                System.out.println(bikeName);
                int bikePrice = Integer.parseInt(statementSelectRs.getString("ProductPrice"));
                String imageUrl = statementSelectRs.getString("ImageURL");
                arrCart.add(new Bike(bikeId, bikeName, bikePrice, imageUrl));
            }

        } catch (SQLException ex) {
            System.out.println("SQL Error");
            System.out.println(ex.getMessage());
        } finally {
            //statementSelectRs.close();
            //preparedStatement.close();
            st.close();
            connection.close();
        }
        return arrCart;
    }


    public ArrayList <Customer> selectAllCustomer() throws SQLException, ClassNotFoundException {
        ArrayList <Customer> arrCus = new ArrayList<>();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/project_db?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root",null);
        PreparedStatement preparedStatement = null;
        ResultSet statementSelectRs = null;
        try{

             preparedStatement = connection
                     .prepareStatement("SELECT * FROM customer");
            statementSelectRs = preparedStatement.executeQuery();
            while (statementSelectRs.next()) {
                String firstName = statementSelectRs.getString("first_name");
                String lastName = statementSelectRs.getString("last_name");
                String username = statementSelectRs.getString("username");
                String password = statementSelectRs.getString("password");
                String address = statementSelectRs.getString("address");
                String contact = statementSelectRs.getString("contact");

                arrCus.add(new Customer(firstName, lastName, username, password, address, contact));
            }


        } catch (SQLException ex) {
            System.out.println("SQL Error");
        } finally {
            statementSelectRs.close();
            preparedStatement.close();
            connection.close();
        }
        return arrCus;
    }

    public void insertOrder(String date, String payment, String custUs) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection=null;
        PreparedStatement preparedStatement = null;
        try{

            connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/project_db?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root",null);

             preparedStatement = connection
                     .prepareStatement("insert into OrderTBL (OrderDate,PaymentMethod,CustomerUsername) "
                             + "values ('" + date + "','" + payment + "','" + custUs + "')");

            int rowsInsert = preparedStatement.executeUpdate();



        } catch (SQLException ex) {
            System.out.println("SQL Error");
            System.out.println(ex.getMessage());

        } finally {
            //preparedStatement.close();
            connection.close();
        }

    }

    public int getlastedOrID() throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection=null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        int orID = -1;
        try{
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/project_db?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root",null);

            preparedStatement = connection
                    .prepareStatement("SELECT OrderID FROM OrderTBL ORDER BY OrderID DESC LIMIT 1");

            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                orID = rs.getInt("OrderID");
            }

        } catch (SQLException ex) {
            System.out.println("SQL Error");
            System.out.println(ex.getMessage());
        } finally {
  //          rs.close();
       //     preparedStatement.close();
            connection.close();
        }
        return orID;
    }


    public void insertOrderLine(int orderID, String pID, int quantity, int price) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection=null;
        PreparedStatement preparedStatement = null;

        try{
          //  connection.setAutoCommit(false);
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/project_db?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root",null);
            preparedStatement = connection
                    .prepareStatement( "insert into OrderLineTBL "
                            + "values ( '" + orderID + "', '" + pID + "','" + quantity + "','" + price + "')");

            int rowsInsert = preparedStatement.executeUpdate();
          //  connection.commit();

        } catch (SQLException ex) {
            System.out.println("SQL Error");
            System.out.println(ex.getMessage());
       //     connection.rollback();
        } finally {
    //        preparedStatement.close();
            connection.close();
        }
    }

}
