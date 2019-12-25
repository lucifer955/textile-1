package sample.ConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {
    public static String username="root";
    public static String password="root";
    public static String conn="jdbc:mysql://localhost:3306/textileshop";

    public static Connection connect() throws SQLException
    {
        return DriverManager.getConnection(conn,username,password);

    }

}
