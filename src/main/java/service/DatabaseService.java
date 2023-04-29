package main.java.service;

import main.java.edu.model.Student;
import main.java.edu.util.DatabaseUtil;
import main.java.edu.util.QueryUtil;

import java.sql.*;

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

    public void addStd(Student std) throws SQLException{
        try(Connection cn = dbu.connect();
            PreparedStatement ps = cn.prepareStatement(qu.addStd())){
            ps.setString(1, std.getfName());
            ps.setString(2, std.getlName());
            ps.setString(3, std.getGender());
            ps.setDate(4, std.getDob());

            int check = ps.executeUpdate();
            if(check > 0){
                System.out.println("Student entered to the System successfully. \n");
            }else{
                System.out.println("Student was not able to enter to the System. Please try again. \n");
            }
        }
    }

    // Created method to delete student.
    public void deleteStd(int stdId) throws SQLException {
        try(
            Connection cn = dbu.connect();
            PreparedStatement ps = cn.prepareStatement(qu.deleteStd())){
            ps.setInt(1, stdId);
            int check = ps.executeUpdate();
            if(check > 0){
                System.out.println("Selected student removed from the system");
            }else{
                System.out.println("Selected student could not be removed from the system. Please try again.");
            }

        }

        // System.out.println("Here we will delete the student " + stdId);
    }

    public Student theStd(int stdId) throws SQLException{
        Student std = null;
        try(Connection cn = dbu.connect();
            PreparedStatement ps = cn.prepareStatement(qu.theStd())){
            ps.setInt(1, stdId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                std = new Student(rs.getString("fName"), rs.getString("lName"), rs.getString("gender"), rs.getDate("dob"));
            }
        }

        return std;
    }

    public void updateStd(int stdId, int detail, String strInput, Date dateInput) throws SQLException {
        // System.out.println("We are about to update student " + stdId);
        try(Connection cn = dbu.connect();
            PreparedStatement ps = cn.prepareStatement(qu.updateStd(detail));
            ){
            switch (detail) {
                case 1:

                case 2:

                case 3:
                    ps.setString(1, strInput);
                    break;
                case 4:
                    ps.setDate(1, dateInput);
                    break;
            }
            ps.setInt(2, stdId);

            int check = ps.executeUpdate();
            if(check > 0){
                System.out.println("Student updated successfully based on the given input.");
            }else{
                System.out.println("Update failed, please run again.");
            }
        }
    }
}
