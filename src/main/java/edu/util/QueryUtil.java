package main.java.edu.util;

public class QueryUtil {
    public String allStdList(){
        return "SELECT * FROM student";
    }

    public String addStd(){
        return "INSERT INTO student (fName, lName, gender, dob) VALUES(?,?,?,?)";
    }

    public String deleteStd(){
        return "DELETE FROM student WHERE (student_id = ?)";
    }
}
