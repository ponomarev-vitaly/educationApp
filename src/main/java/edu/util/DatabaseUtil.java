package main.java.edu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    private String url = "jdbc:mysql://localhost:3306/edu_pract";
    private String uname = "root";
    private String pass = "volgogradskaya3-60";

    public Connection connect() throws SQLException {
        Connection cn = DriverManager.getConnection(url, uname, pass);
        return cn;
    }
}
