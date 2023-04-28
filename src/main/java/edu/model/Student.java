package main.java.edu.model;

import java.sql.Date;

public class Student {
    // POJO -> Plain Old Java Object

    private int student_id;
    private String fName;
    private String lName;
    private String gender;
    private Date dob;

    public Student(String fName, String lName, String gender, Date dob) {
        this.fName = fName;
        this.lName = lName;
        this.gender = gender;
        this.dob = dob;
    }

    public Student(int student_id, String fName, String lName, String gender, Date dob) {
        this.student_id = student_id;
        this.fName = fName;
        this.lName = lName;
        this.gender = gender;
        this.dob = dob;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
// We should add more logic in printing out the information from the table.
    public String toString(){
        String initial = (student_id < 10 ? " " : " ") + student_id + " -> " + fName.toUpperCase() + " " + lName.toUpperCase();
        
        for (int initialSize = initial.length(); initialSize <= 30; initialSize++) {
            initial += " ";
        }

        initial += "\t (" + gender + ") | DOB -> " + dob;
        return initial;
    }
}
