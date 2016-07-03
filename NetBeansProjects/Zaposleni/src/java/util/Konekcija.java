package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Konekcija {

    public Connection connect;
    private static Konekcija instance;

    private Konekcija() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //connect DB
            connect = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");

        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getMessage());

        }
    }

    
    public static Konekcija getInstance() {
        if (instance == null) {
            instance = new Konekcija();
        }
        return instance;
    }   
}
