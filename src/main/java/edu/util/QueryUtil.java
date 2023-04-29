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

    public String theStd(){
        return "SELECT * FROM student WHERE student_id = ?";
    }

    public String updateStd(int detail){
        String result = "UPDATE student SET ";
        switch (detail) {
            case 1:
                result += " fName = ? ";
                break;
            case 2:
                result += " lName = ? ";;
                break;
            case 3:
                result += " gender = ? ";;
                break;
            case 4:
                result += " dob = ? ";;
                break;
        }
        result += " WHERE student_id = ? ";
        return result;
    }

    public String stdListTC(){
        return "Select student_id, concat(fName, ' ' , lName) as name " + " from student where student_id in " +
        " (Select distinct(student_id) From TakenCourse)";
    }

    public String stdCourseTc(){
        return "SELECT name, finalScore FROM " +
        " TakenCourse tc JOIN Course c on (tc.course_id = c.course_id) " +
        " WHERE student_id = ? ";
    }
}
