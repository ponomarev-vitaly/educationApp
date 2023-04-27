import java.sql.Connection;
import java.sql.DriverManager;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        /**
         * 1. load and register the driver/connector;
         * 2. perform the connection (Location of DB, Username, Password);
         * 3. prepare the query;
         * 4. execute the query;
         * 5. perform the logic based on the query;
         * 6. close the connection;
         */

        String url = "jdbs:mysql://localhost:3306/edu_pract"; // Java data base connection.
        String username = "root";
        String password = "volgogradskaya3-60";
        Connection db = DriverManager.getConnection(url, username, password);
    }
}