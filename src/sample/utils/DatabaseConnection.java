package sample.utils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.model.Activity;

import sample.Main;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Properties;

public class DatabaseConnection {

    public static Statement statement;
    public static String returnValue;
    public static int returnValueInt;
    static int[] returnValueArr;
    //"jdbc:mysql://localhost:3306/project_2";

    private Properties properties;
    private Connection connection;
    PreparedStatement prepstate = null;

    Main main = new Main();


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
            }
        } catch (SQLException var2) {
            System.out.println("An error occurred on executing the query for testQuery");
        }

    }


    public static String logInVerification(String email) {
        String password = null;
        
        try {
            password = String.valueOf(statement.executeQuery("SELECT password FROM user WHERE email = '" + email + "';"));


        } catch (SQLException var2) {
            System.out.println("An error occurred on executing the query for loginVerification");
        }

        return password;
    }

    public static int getUsersSize() {
        DB_Connection();

        try {
            ResultSet rs = statement.executeQuery("SELECT COUNT(userid) FROM users");
            if (rs.next()) {
                returnValueInt = rs.getInt(1);
                return returnValueInt;
            }
        } catch (SQLException var1) {
            System.out.println("An error occurred on executing the query.");
        }

        return 0;
    }

    public static String getPassword(int counter) {
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
        try {
            statement.executeUpdate("INSERT INTO user (email, username, password)VALUES (  '" + email + "','" + username + "','" + password + "')");
        } catch (SQLException var7) {
            System.out.println("An error occurred on executing the registration query.");
        }


    }


    public static void updateEmail(String email){
        Main main = new Main();
        try {
            statement.executeUpdate("UPDATE user SET email = '" + email + "' WHERE username = " + main.getLoggedInUser());
        } catch (SQLException var7) {
            System.out.println("An error occurred on executing the registration query for updateEmail");
        }
    }

    static void addActivity(String name, String location, String contact, String type, byte indoor, byte outdoor) {
        try {
            statement.executeUpdate("INSERT INTO activity (name, location, contact, type, indoor, outdoor) VALUES ('" + name + "','" + location + "','" + contact + "','" + type + "','" + indoor + "','" + outdoor + "'");
            System.out.println("Book added.");
        } catch (SQLException var6) {
            System.out.println("An error occurred on executing the adding query for addActivity");
        }
    }


    static void addRating(String userid, String activityid, int rating) {

        try {
            statement.executeQuery("INSERT INTO rating (userid, activityid, rating)VALUES ('" + userid + "','" + activityid + "',''" + rating + "'");
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

    public ObservableList<Activity> selectActivities(String ActivityName) {


        ObservableList<Activity> activitiesList = FXCollections.observableArrayList();
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT name, location, contact, type, indoor, outdoor FROM activity WHERE name = '" + ActivityName + "'"+";");
            String rsName;
            String rsLocation;
            String rsContact;
            String rsType;
            byte rsIndoor;
            byte rsOutdoor;
            while (rs.next()) {
                rsName = rs.getString("name");
                rsLocation = rs.getString("location");
                rsContact = rs.getString("contact");
                rsType = rs.getString("type");
                rsIndoor = rs.getByte("indoor");
                rsOutdoor = rs.getByte("outdoor");
                activitiesList.add(new Activity(rsName, rsLocation, rsContact,rsType, rsIndoor, rsOutdoor));
            }
        } catch (SQLException var10) {
            System.out.println(var10.getMessage());
            System.out.println("An error occurred on executing select query for selectActivities");
        }

        return activitiesList;
    }

    public ObservableList<Activity> browseController() {
        ObservableList<Activity> listForDisplay = FXCollections.observableArrayList();
        try {
            statement = connection.createStatement();
            String rsName;
            String rsLocation;
            String rsContact;
            String rsType;
            byte rsIndoor;
            byte rsOutdoor;
            ResultSet rs = statement.executeQuery("SELECT `name`, `location`, `contact`, `type`, `indoor`, `outdoor` FROM activity");
            while (rs.next()) {
                rsName = rs.getString("name");
                rsLocation = rs.getString("location");
                rsContact = rs.getString("contact");
                rsType = rs.getString("type");
                rsIndoor = rs.getByte("indoor");
                rsOutdoor = rs.getByte("outdoor");

                listForDisplay.add(new Activity(rsName, rsLocation, rsContact, rsType, rsIndoor, rsOutdoor));
            }
        } catch (SQLException | NullPointerException ex) {
            System.err.println(LocalDateTime.now() + " : " + ex.getMessage());
            System.out.println("An error occurred on executing the query.");
        }
        return listForDisplay;
    }

    public ObservableList<Activity> sortByType() {

        ObservableList<Activity> activitiesList = FXCollections.observableArrayList();
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT  `name`, `location`, `contact`, `type`, `indoor`, `outdoor` FROM activity ORDER BY type ASC");
            String rsName;
            String rsLocation;
            String rsContact;
            String rsType;
            byte rsIndoor;
            byte rsOutdoor;
            while (rs.next()) {
                rsName = rs.getString("name");
                rsLocation = rs.getString("location");
                rsContact = rs.getString("contact");
                rsType = rs.getString("type");
                rsIndoor = rs.getByte("indoor");
                rsOutdoor = rs.getByte("outdoor");
                activitiesList.add(new Activity(rsName, rsLocation, rsContact,rsType, rsIndoor, rsOutdoor));
            }
        } catch (SQLException var10) {
            System.out.println("An error occurred on executing select query.");
        }

        return activitiesList;
    }

    public ObservableList<Activity> sortByLocation() {

        ObservableList<Activity> activitiesList = FXCollections.observableArrayList();
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT  `name`, `location`, `contact`, `type`, `indoor`, `outdoor` FROM activity ORDER BY location ASC");
            String rsName;
            String rsLocation;
            String rsContact;
            String rsType;
            byte rsIndoor;
            byte rsOutdoor;
            while (rs.next()) {
                rsName = rs.getString("name");
                rsLocation = rs.getString("location");
                rsContact = rs.getString("contact");
                rsType = rs.getString("type");
                rsIndoor = rs.getByte("indoor");
                rsOutdoor = rs.getByte("outdoor");
                activitiesList.add(new Activity(rsName, rsLocation, rsContact, rsType, rsIndoor, rsOutdoor));
            }
        } catch (SQLException var10) {
            System.out.println("An error occurred on executing select query.");
        }

        return activitiesList;
    }

    public static String getID(String email){

        try {
            return String.valueOf((statement.executeQuery("SELECT id from user WHERE email = '" + email + "')")));

        } catch (SQLException var1) {
            System.out.println("An error occurred on executing the query for getID");
        }

        return "";
    }

    public static ObservableList<Activity> getFavorites(String iduser){
        ObservableList<Activity> list = FXCollections.observableArrayList();

        try
        {
            /*statement.executeQuery("SELECT activity_idactivity from user_has_activity WHERE user_iduser = '" + iduser + "'");
            String query = "SELECT activity_idactivity from user_has_activity WHERE user_iduser = '" + iduser + "'";
            PreparedStatement ps = DatabaseConnection.prepareStatement(query);
            ps.setInt(1, orderId);*/
            ResultSet rs = statement.executeQuery("SELECT activity_idactivity from user_has_activity WHERE user_iduser = '" + iduser + "'");
            while(rs.next())
            {
                int activityId = rs.getInt(1);

                Activity activity = selectActivity(activityId);
                list.add(activity);
            }
        } catch (SQLException var1) {
            System.out.println("An error occurred on executing the query for getFavorites");
        }

        return list;

    }
    public ObservableList<Activity> sortByRating() {

        ObservableList<Activity> activitiesList = FXCollections.observableArrayList();
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT  `name`, `location`, `contact`, `type`, `indoor`, `outdoor` FROM activity ORDER BY location ASC");
            String rsName;
            String rsLocation;
            String rsContact;
            String rsType;
            byte rsIndoor;
            byte rsOutdoor;
            while (rs.next()) {
                rsName = rs.getString("name");
                rsLocation = rs.getString("location");
                rsContact = rs.getString("contact");
                rsType = rs.getString("type");
                rsIndoor = rs.getByte("indoor");
                rsOutdoor = rs.getByte("outdoor");
                activitiesList.add(new Activity(rsName, rsLocation, rsContact,rsType, rsIndoor, rsOutdoor));
            }
        } catch (SQLException var10) {
            System.out.println("An error occurred on executing select query.");
        }

        return activitiesList;
    }

    public static Activity selectActivity(int id) {

        Activity activity = null;

        try {
            String name = String.valueOf(statement.executeQuery("select name from activity where idactivity = " + id));
            String location = String.valueOf(statement.executeQuery("select location from activity where idactivity = " + id));
            String contact = String.valueOf(statement.executeQuery("select contact from activity where idactivity = " + id));
            String type = String.valueOf(statement.executeQuery("select type from activity where idactivity = " + id));
            ResultSet rsIndoor = statement.executeQuery("select indoor from activity where idactivity = " + id);
            ResultSet rsOutdoor = statement.executeQuery("select outdoor from activity where idactivity = " + id);
            byte indoor = rsIndoor.getByte("indoor");
            byte outdoor = rsOutdoor.getByte("outdoor");


            activity = new Activity(name, location, contact, type, indoor, outdoor);


        } catch (SQLException var1) {
            System.out.println("An error occurred on executing the query for selectActivity");
        }
        return activity;
    }


}

