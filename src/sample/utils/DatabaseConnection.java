package sample.utils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.model.Activity;

import javax.swing.table.DefaultTableModel;

import sample.Main;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class DatabaseConnection {

    static Statement statement;
    static String returnValue;
    static int returnValueInt;
    static int[] returnValueArr;
    //"jdbc:mysql://localhost:3306/project_2";

    private Properties properties;
    private Connection connection;






    public DatabaseConnection() {
        String url = databaseConnectionURl();
        setConnectionProperties();
        try {
            connection = DriverManager.getConnection(url, properties);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to connect to the server");
        }
    }

    public static void DB_Connection() {
    }

    protected Connection getConnection() {
        return connection;
    }

    //Close connection when everything is finished
    public void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    private String databaseConnectionURl() {
        String url = "jdbc:mysql://den1.mysql3.gear.host";
        String port = "3306";
        String DBName = "activityfinder1";

        return url + ":" + port + "/" + DBName + "?";
    }

    private void setConnectionProperties() {
        properties = new Properties();
        properties.setProperty("user", "activityfinder1");
        properties.setProperty("password", "Bf30C65~34?O");
        properties.setProperty("useSSL", "false");
        properties.setProperty("autoReconnect", "true");
    }


    public void testQuery() {
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM user;");
            while (rs.next()) {
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                System.out.println(rs.getString(4));
            }
        } catch (SQLException var2) {
            System.out.println("An error occurred on executing the query.");
        }

    }



    //changed to just fetching username since we don't know the ID before the user has given us their login

    public static String getEmail(int counter) {
        try {
            ResultSet rs = statement.executeQuery("SELECT email FROM user WHERE iduser =" + counter);
            if (rs.next()) {
                returnValue = rs.getString(1);

                return returnValue;
            }
        } catch (SQLException var2) {
            System.out.println("An error occurred on fetching email query");
        }

        return "";
    }

    public static int getUsersSize() {


        try {
            ResultSet rs = statement.executeQuery("SELECT COUNT(iduser) FROM user");
            if (rs.next()) {
                returnValueInt = rs.getInt(1);
                return returnValueInt;
            }
        } catch (SQLException var1) {
            System.out.println("An error occurred on fetching user size");
        }

        return 0;
    }

    public static String getPassword(int counter) {
        try {
            ResultSet rs = statement.executeQuery("SELECT password FROM user WHERE iduser = " + counter);
            if (rs.next()) {
                returnValue = rs.getString(1);
                return returnValue;
            }
        } catch (SQLException var2) {
            System.out.println("An error occurred on fetching password query.");
        }

        return "";
    }

    static void addRegistration(String name, String address, String email, String username, String password) {
        try {
            statement.executeUpdate("INSERT INTO user (email, username, password)VALUES (  '" + email + "','" + username + "','" + password + "')");
        } catch (SQLException var7) {
            System.out.println("An error occurred on executing the registration query.");
        }



}

    public static void updateEmail(String email){
        Main main = new Main();
        try {
            statement.executeUpdate("UPDATE user SET email = '" + email + "' WHERE id = " + main.getLoggedInUser().getId());
        } catch (SQLException var7) {
            System.out.println("An error occurred on executing the registration query.");
        }
    }

    public static void addActivity(String name, String location, String contact, String type, boolean indoor, boolean outdoor) {
        try {
            statement.executeUpdate("INSERT INTO activity (name, location, contact, type, indoor, outdoor) VALUES ('" + name + "','" + location + "','" + contact + "','" + type + "','"+ indoor + "','" + outdoor + "'");
            System.out.println("Book added.");
        } catch (SQLException var6) {
            System.out.println("An error occurred on executing the adding query.");
        }
    }


    static void addRating(int userid, String activityid, int rating) {

        try {
            statement.executeQuery("INSERT INTO rating (userid, activityid, rating)VALUES WHERE userid=userid ('" + userid + "','" + activityid + "',''" + rating + "'");
            System.out.println("rating added");
        } catch (SQLException var7) {
            System.out.println("");


        }
    }


    static void addFavorite(String userid, String favouriteid, String eventid) {
        try {
            statement.executeQuery("INSERT INTO favourites (userid, activityid, rating)VALUES ('" + userid + "','" + favouriteid + "',''" + eventid + "'");
            System.out.println("favorite added");
        } catch (SQLException var7) {
            System.out.println("");


        }
    }

    public static ObservableList<Activity> selectActivities(String name) {

        ObservableList<Activity> activitiesList = FXCollections.observableArrayList();
        try {
            ResultSet rs = statement.executeQuery("SELECT location FROM activity WHERE name = " + name);
            Activity activity;
            while (rs.next()) {
                activity = new Activity(rs.getInt("id"), rs.getString("name"), rs.getString("location"), rs.getString("contact"), rs.getString("type"), rs.getBoolean("indoor"), rs.getBoolean("outdoor"));
                activitiesList.add(activity);
            }
        } catch (SQLException var10) {
            System.out.println("An error occurred on executing select query.");
        }
        return activitiesList;
    }


    public static void showActivity(String name) {
        ObservableList<Activity> list = selectActivities(name);

        Object[] row = new Object[2];
        for (int i = 0; i < list.size(); i = i + 2) {
            row[i] = list.get(i).getLocation();
            System.out.println(row[i]);
            row[i + 1] = list.get(i).getType();
            System.out.println(row[i + 1]);
        }
    }

    public static int getID(String email) {

        try {
            ResultSet rs = statement.executeQuery("SELECT iduser FROM user WHERE email = " + email);
            if (rs.next()) {
                returnValue = rs.getString(1);
                return returnValueInt;
            }
        } catch (SQLException var2) {
            System.out.println("An error occurred on fetching ID query");


        }

        return 0;
    }


    public static void newUser(String email, String password){

        try {
            statement.executeQuery("INSERT into user (password, email) VALUES (" + password + "," + email + ")");

        } catch (SQLException var1) {
            System.out.println("An error occurred on executing the query.");
        }


    }


    
}

