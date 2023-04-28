package main.java.service;

import main.java.edu.model.Student;
import main.java.edu.util.DatabaseUtil;
import main.java.edu.util.QueryUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseService {
    private DatabaseUtil dbu = new DatabaseUtil();
    private QueryUtil qu = new QueryUtil();
    public void allStdList() throws SQLException {
        // System.out.println("Here we will display all students in a list...");
        try(
                Connection cn = dbu.connect();
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(qu.allStdList());
        ) {

            Student std = null;
            while (rs.next()) {
                std = new Student(rs.getInt("student_id"), rs.getString("fName"), rs.getString("lName"),
                        rs.getString("gender"), rs.getDate("dob"));
                System.out.println(std.toString());
            }
        }
    }
}
