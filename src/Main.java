import main.java.edu.model.Student;
import main.java.service.DatabaseService;

import java.sql.*;
import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static Scanner scan = new Scanner(System.in);
    private static String input = "";
    /*C-reate, R-ead, U-pdate, D-elete*/
    private static boolean mainMenu = true;
    private static boolean stdMenu = true;
    private static boolean crMenu = true;
    private static boolean tcMenu = true;
    private static boolean isNew = true;
    private static boolean isList = true;
    private static boolean isUpdate = true;
    private static boolean isDelete = true;
    private static DatabaseService dbs = new DatabaseService();

    public static void main(String[] args) {
        /**
         * 1. load and register the driver/connector;
         * 2. perform the connection (Location of DB, Username, Password) (double click connector);
         * 3. prepare the query (open and type query);
         * 4. execute the query (Execute the query);
         * 5. perform the logic based on the query (check the given table);
         * 6. close the connection (close the workbench);
         */

//        try {
//            String url = "jdbc:mysql://localhost:3306/edu_pract"; // Java data base connection.
//            String username = "root";
//            String password = "volgogradskaya3-60";
//            Connection db = DriverManager.getConnection(url, username, password);
//
//            Statement st = db.createStatement();
//
//            // Insert data in the student table.
//            st.execute("INSERT INTO student values (12, 'Mustafa', 'Onat', 'M', '1999-06-10')");
//            ResultSet rs = st.executeQuery("Select * from student"); // Make a query.
//
//            while (rs.next()) {
//                // System.out.println(rs.getInt(2));
//                System.out.println(rs.getInt("student_ID") + "\t\t" +
//                                   rs.getString("fName") + "\t\t" +
//                                   rs.getString("lName") + "\t\t" +
//                                   rs.getString("gender") + "\t\t" +
//                                   rs.getString("dob"));
//            }
//
//            // System.out.println("We are all good!");
//            db.close(); // Close DB connection.
//
//        } catch (SQLException e) {
//            // System.out.println("We have a DB error!");;
//        }
//
//        System.out.println("<-------------------------------------------------------->");
//
        // Call the Main Menu.
        try {
            while(input.compareTo("P") != 0){
                System.out.println("\n\n");
                if(mainMenu){
                    displayMainMenu();
                } else if (stdMenu){
                    displayStdMenu();
                } else if (crMenu){
                    displayCourseMenu();
                } else if(tcMenu){
                    displayTCMenu();
                }
            }
        } catch (SQLException e) {
            System.out.println("We have DB issue, please reach to Help Desk.");
        }
    }

    private static void displayMainMenu(){
        System.out.println("------------------EDUCATION APPLICATION------------------");
        System.out.println("------------------       MAIN MENU     ------------------");
        System.out.println("(S)tudents");
        System.out.println("(C)ourses");
        System.out.println("(T)aken courses");
        System.out.println("(P)ower off");

        input = scan.next().toUpperCase().substring(0,1);
        if(input.compareTo("S") == 0){
            mainMenu = false;
            stdMenu = true;
        } else if(input.compareTo("C") == 0){
            mainMenu = false;
            crMenu = true;
        } else if(input.compareTo("T") == 0) {
            mainMenu = false;
            tcMenu = true;
        }
    }

    private static void displayStdMenu() throws SQLException {
        System.out.println("------------------EDUCATION APPLICATION------------------");
        System.out.println("------------------     STUDENT MENU    ------------------");
        System.out.println("(A)DD NEW STUDENT");
        System.out.println("(L)IST OF STUDENTS");
        System.out.println("(U)PDATE OF STUDENTS");
        System.out.println("(D)ELETE A STUDENT DETAIL");
        System.out.println("(M)ain menu");
        System.out.println("(P)ower off");
        System.out.print("-------------------------------------------------------->");

        input = scan.next().toUpperCase().substring(0,1);
        if(input.compareTo("A") == 0){
            System.out.println("\n\n----------------     ADD A NEW STUDENT    ---------------");
            System.out.println("First Name: ");
            String fName = scan.next().trim().toUpperCase();
            System.out.println("Last Name: ");
            String lName = scan.next().trim().toUpperCase();
            System.out.println("Gender (F/M): ");
            String gender = scan.next().trim().toUpperCase().substring(0,1);
            System.out.println("Date of Birth (yyyy-mm-dd): ");
            String dob = scan.next().trim();
            dbs.addStd(new Student(fName, lName, gender, Date.valueOf(dob)));
        } else if(input.compareTo("L") == 0){
            System.out.println("\n\n------------------     STUDENT LIST    ------------------");
            dbs.allStdList();
        } else if(input.compareTo("U") == 0) {
            System.out.println("\n\n------------------     STUDENT LIST    ------------------");
            dbs.allStdList();
            System.out.println("Enter student ID > ");
            int id = scan.nextInt();
            Student std = dbs.theStd(id);
            if(std != null){
                System.out.println("\n\n--------     Select one detail to update    ---------");
                System.out.println("1. First Name -> " + std.getfName());
                System.out.println("2. Last Name -> " + std.getlName());
                System.out.println("3. Gender -> " + std.getGender());
                System.out.println("4. Date of birth -> " + std.getDob());
                System.out.println("-------------------------------------------------------->");
                int detail = scan.nextInt();
                String strInput = null;
                Date dateInput = null;

                switch (detail) {
                    case 1:
                        System.out.print(" Please enter First Name > ");
                        strInput = scan.next().trim().toUpperCase();
                        break;
                    case 2:
                        System.out.print("Please enter Last Name > ");
                        strInput = scan.next().trim().toUpperCase();
                        break;
                    case 3:
                        System.out.println("Please enter the Gender (F/M) > ");
                        strInput = scan.next().trim().toUpperCase().substring(0, 1);
                        break;
                    case 4:
                        System.out.println("Please enter Date of birth (yyyy-mm-dd) > ");
                        dateInput = Date.valueOf(scan.next().trim().toUpperCase());
                        break;
                }
                if(strInput != null || dateInput != null) {
                    dbs.updateStd(id, detail, strInput, dateInput);
                }else{
                    System.out.println("Please enter a valid detail.");
                }

            }
        } else if(input.compareTo("D") == 0) {
            System.out.println("\n\n------------------     STUDENT LIST    ------------------");
            dbs.allStdList();
            System.out.println("Enter Student ID > ");
            int id = scan.nextInt();
            System.out.println("Please type Delete to validate the action > ");
            String confirm = scan.next();
            if(id > 0 && confirm.compareTo("Delete")==0){
                dbs.deleteStd(id); // Method to delete student.
            }else{
                System.out.println("Delete validation failed...");
            }
        } else if(input.compareTo("M") == 0){
            stdMenu = false;
            mainMenu = true;
        }
    }

    private static void displayCourseMenu(){
        System.out.println("UNDER DEVELOPMENT");
        crMenu = false;
        mainMenu = true;
    }

    private static void displayTCMenu(){
        System.out.println("UNDER DEVELOPMENT");
        tcMenu = false;
        mainMenu = true;
    }
}