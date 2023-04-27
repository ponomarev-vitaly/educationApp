package main.java.service;

import main.java.edu.util.DatabaseUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseService {
    private DatabaseUtil dbu = new DatabaseUtil();
    public void allStdList() throws SQLException {
        // System.out.println("Here we will display all students in a list...");
        Connection cn = dbu.connect();
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM student");
    }
}
