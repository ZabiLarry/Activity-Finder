package sample.utils;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import org.w3c.dom.Text;
import sample.model.Activity;


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




    public DatabaseConnection() {
        String url = databaseConnectionURl();
        setConnectionProperties();
        try {
            connection = DriverManager.getConnection(url, properties);
            statement = connection.createStatement();
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

    public static int getActivityID(StringProperty name, StringProperty type){

        try {
            return Integer.parseInt(String.valueOf(statement.executeQuery("SELECT idactivity FROM activity WHERE name = '" + name + "' AND type = '" + type + "';")));

        } catch (SQLException var2) {
            System.out.println("An error occurred on executing the query for getActivityID");
        }
        return 0;
    }


    //changed to just fetching username since we don't know the ID before the user has given us their login

    public static String getEmailCommercial(int counter) {
        try {
            ResultSet rs = statement.executeQuery("SELECT email FROM commercialuser WHERE idcommercialUser =" + counter);
            if (rs.next()) {
                returnValue = rs.getString(1);

                return returnValue;
            }
        } catch (SQLException var2) {
            System.out.println("An error occurred on fetching commercial email query");
        }

        return "";
    }

    public static String getEmailRegular(int counter) {
        try {
            ResultSet rs = statement.executeQuery("SELECT email FROM user WHERE iduser =" + counter);
            if (rs.next()) {
                returnValue = rs.getString(1);

                return returnValue;
            }
        } catch (SQLException var2) {
            System.out.println("An error occurred on fetching regular email query");
        }

        return "";
    }

    public static String getPhone(int counter) {
        try {
            ResultSet rs = statement.executeQuery("SELECT phoneNumber FROM user WHERE iduser =" + counter);
            if (rs.next()) {
                returnValue = rs.getString(1);

                return returnValue;
            }
        } catch (SQLException var2) {
            System.out.println("An error occurred on fetching email query");
        }

        return "";
    }

    public static String getAddress(int counter) {
        try {
            ResultSet rs = statement.executeQuery("SELECT address FROM user WHERE iduser =" + counter);
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

    public static String getPasswordRegular(int counter) {
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

    public static String getPasswordCommercial(int counter) {
        try {
            ResultSet rs = statement.executeQuery("SELECT password FROM commercialuser WHERE idcommercialuser = " + counter);
            if (rs.next()) {
                returnValue = rs.getString(1);
                return returnValue;
            }
        } catch (SQLException var2) {
            System.out.println("An error occurred on fetching password query.");
        }

        return "";
    }




    public static void updateEmail(String email){

        try {
            statement.executeUpdate("UPDATE user SET email = '" + email + "' WHERE id = " + AuthenticationSingleton.getInstance().getUser().getId());
        } catch (SQLException var7) {
            System.out.println("An error occurred on executing the registration query for updateEmail");
        }
    }

    public static void updateActivity(int idactivity){
        try {
            statement.executeUpdate("UPDATE user SET email = '" +  "' WHERE id = " );
        } catch (SQLException var7) {
            System.out.println("An error occurred on executing the registration query for updateActivity");
        }
    }

    public static void deleteActivity(int idactivity){

        try {
            statement.executeUpdate("DELETE FROM activity WHERE idactivity = '" + idactivity + "'");
        } catch (SQLException var7) {
            System.out.println("An error occurred on executing the registration query for deleteEmail");
        }
    }

    public static void addActivity(String name, String location, String contact, String type, boolean indoor, boolean outdoor) {
        try {
            statement.executeUpdate("INSERT INTO activity (name, location, contact, type, indoor, outdoor) VALUES ('" + name + "','" + location + "','" + contact + "','" + type + "','" + indoor + "','" + outdoor + "'");
            System.out.println("Book added.");
        } catch (SQLException var6) {
            System.out.println("An error occurred on executing the adding query for addActivity");
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


    public static void addFavorite(int userid, int favouriteid) {

        try {
            statement.executeQuery("INSERT INTO user_has_activity VALUES (" + userid + "," + favouriteid + ",null,null)");
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

    /*public static String getID(String email){

        try {
            return String.valueOf((statement.executeQuery("SELECT id from user WHERE email = '" + email + "')")));

        } catch (SQLException var1) {
            System.out.println("An error occurred on executing the query for getID");
        }

        return "";
    }*/

    public static int getIDRegular(String email) {

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
    public static int getIDCommercial(String email) {

        try {
            ResultSet rs = statement.executeQuery("SELECT idcommercialUser FROM commercialuser WHERE email = " + email);
            if (rs.next()) {
                returnValue = rs.getString(1);
                return returnValueInt;
            }
        } catch (SQLException var2) {
            System.out.println("An error occurred on fetching ID query");


        }

        return 0;
    }

    public static String getName(String email) {

        try {
            ResultSet rs = statement.executeQuery("SELECT name FROM commercialuser WHERE email = " + email);
            if (rs.next()) {
                returnValue = rs.getString(1);
                return returnValue;
            }
        } catch (SQLException var2) {
            System.out.println("An error occurred on fetching ID query");


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



    public ObservableList<Activity> sortByRFavorite(int userId) {

        ObservableList<Activity> activitiesList = FXCollections.observableArrayList();
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT  `name`, `location`, `contact`, `type`, `indoor`, `outdoor` FROM activity WHERE  = '" + userId + "'" + " ORDER BY ASC");
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
            System.out.println("An error occurred on executing query.");
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


    public boolean isInt(TextField input){

        try{
            int test = Integer.parseInt(input.getText());
            System.out.println("works");
            return true;


        }catch(NumberFormatException e){
            System.out.println("fails");
            return false;

        }
    }

    public void isString(TextField input){

        if(!input.getText().matches("[a-zA-Z]+")){
            System.out.println("only letters");
        }
        else{
            System.out.println("works");
        }
    }

    public ObservableList<Activity> sortByRating() {

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









}



