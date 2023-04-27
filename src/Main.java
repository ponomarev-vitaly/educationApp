import java.sql.*;
import java.util.Stack;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        /**
         * 1. load and register the driver/connector;
         * 2. perform the connection (Location of DB, Username, Password) (double click connector);
         * 3. prepare the query (open and type query);
         * 4. execute the query (Execute the query);
         * 5. perform the logic based on the query (check the given table);
         * 6. close the connection (close the workbench);
         */

        try {
            String url = "jdbc:mysql://localhost:3306/edu_pract"; // Java data base connection.
            String username = "root";
            String password = "volgogradskaya3-60";
            Connection db = DriverManager.getConnection(url, username, password);

            Statement st = db.createStatement();

            ResultSet rs = st.executeQuery("Select * from student");


            while (rs.next()) {
                // System.out.println(rs.getInt(2));
                System.out.println(rs.getInt("student_ID") + "\t\t" +
                                   rs.getString("fName") + "\t\t" +
                                   rs.getString("lName") + "\t\t" +
                                   rs.getString("gender") + "\t\t" +
                                   rs.getString("dob"));
            }

            // System.out.println("We are all good!");
            db.close();

        } catch (SQLException e) {
            // System.out.println("We have a DB error!");;
        }
    }
}