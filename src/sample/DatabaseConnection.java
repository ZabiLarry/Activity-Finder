package sample;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

    static String url = "jdbc:mysql://den1.mysql5.gear.host/project2group14?user=project2group14&password=Rp93~j70!tGG";
    static Statement statement;
    static String returnValue;

    //"jdbc:mysql://localhost:3306/project_2";



    static void DB_Connection() {
        try {
            Connection c = (Connection)DriverManager.getConnection(url);
            statement = c.createStatement();
            System.out.println("The connection works");
        } catch (SQLException var1) {
            System.out.println("The connection fails");
        }

    }

    static String getUsername(int counter) {
        DB_Connection();

        try {
            ResultSet rs = statement.executeQuery("SELECT username FROM users WHERE id = " + counter);
            if (rs.next()) {
                returnValue = rs.getString(1);
                return returnValue;
            }
        } catch (SQLException var2) {
            System.out.println("An error occurred on executing the query.");
        }

        return "";
    }

    static String getPassword(int counter) {
        DB_Connection();

        try {
            ResultSet rs = statement.executeQuery("SELECT password FROM users WHERE id = " + counter);
            if (rs.next()) {
                returnValue = rs.getString(1);
                return returnValue;
            }
        } catch (SQLException var2) {
            System.out.println("An error occurred on executing the query.");
        }

        return "";
    }

    static void addRegistration(String name, String address, String email, String username, String password) {
        DB_Connection();

        try {
            statement.executeUpdate("INSERT INTO users (name, address, ssn, email, username, password)VALUES (  '" + name + "','" + address + "','" + email + "','" + username + "','" + password + "')");
        } catch (SQLException var7) {
            System.out.println("An error occurred on executing the registration query.");
        }







}

    static void addActivities(String name, String location, String contact, String type) {
        DB_Connection();

        try {
            statement.executeUpdate("INSERT INTO activity (name, location, contact, type) VALUES ('" + name + "','" + location + "','" + contact + "','" + type + "'");
            System.out.println("Book added.");
        } catch (SQLException var6) {
            System.out.println("An error occurred on executing the adding query.");
        }

    }








}


