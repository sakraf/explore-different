package skf.controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {
    private static String serverName = "localhost";
    private static String dbName = "project_db";
    private static String portNumber = "3306";
    private static String userID = "root";
    private static String password ="";

    public static Connection getConnection()throws Exception {
        String url = "jdbc:mysql://"+serverName+":"+portNumber+"/databaseName="+dbName+"?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, userID, password);
    }


}
