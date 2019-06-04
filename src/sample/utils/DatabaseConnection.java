package sample.utils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import sample.model.Activity;


import java.sql.*;
import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.Collections;

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

    public static int getActivityID(String name, String type) {

        try {
            return Integer.parseInt(String.valueOf(statement.executeQuery("SELECT idactivity FROM activity WHERE name = '" + name + "' AND type = '" + type + "';")));

        } catch (SQLException var2) {
            System.out.println("An error occurred on executing the query for getActivityID");
        }
        return 0;
    }

    public String forgottenPassword(String email){
        String returnVal = null;
        String query = "SELECT password FROM user WHERE email = ?;";
        try{
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, email);
            ResultSet rs = st.executeQuery();

            if(rs.next()){
                returnVal = rs.getString("password");
            }

            return returnVal;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return returnVal;
    }


    //changed to just fetching username since we don't know the ID before the user has given us their login

    public String getEmailCommercial(int counter) {
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT email FROM commercialuser WHERE idcommercialUser = '" + counter + "'"+";");
            while (rs.next()) {
                returnValue = rs.getString("email");

            }
        } catch (SQLException var2) {
            System.out.println("An error occurred on fetching commercial email query");
        }

        return returnValue;
    }

    public ObservableList<Activity> selectActivities(String ActivityName) {


        ObservableList<Activity> activitiesList = FXCollections.observableArrayList();
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM activity WHERE name = '" + ActivityName + "'"+";");
            int rsId;
            String rsName;
            String rsLocation;
            String rsContact;
            String rsType;
            byte rsIndoor;
            byte rsOutdoor;
            while (rs.next()) {
                rsId = rs.getInt("idActivity");
                rsName = rs.getString("name");
                rsLocation = rs.getString("location");
                rsContact = rs.getString("contact");
                rsType = rs.getString("type");
                rsIndoor = rs.getByte("indoor");
                rsOutdoor = rs.getByte("outdoor");
                activitiesList.add(new Activity(rsId,rsName, rsLocation, rsContact, rsType, rsIndoor, rsOutdoor));
            }
        } catch (SQLException var10) {
            System.out.println(var10.getMessage());
            System.out.println("An error occurred on executing select query for selectActivities");
        }

        return activitiesList;
    }

    public  ObservableList<Activity> getOwnedActivities() {

        ObservableList<Activity> activitiesList = FXCollections.observableArrayList();
        int receivedId;
        int rsID;
        String rsName;
        String rsLocation;
        String rsContact;
        String rsType;
        byte rsIndoor;
        byte rsOutdoor;
        int test = 1;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT activity_idactivity from commercialuser_has_activity WHERE commercialUser_idcommercialUser = '" + AuthenticationSingleton.getInstance().getUser().getId() + "'"+";");
            while (rs.next()) {
                receivedId = rs.getInt("activity_idactivity");

                try {
                    ResultSet rs2 = statement.executeQuery("SELECT  * FROM activity WHERE idactivity = '" + receivedId + "'"+";");
                    while (rs2.next()) {
                        rsID = rs2.getInt("idactivity");
                        rsName = rs2.getString("name");
                        rsLocation = rs2.getString("location");
                        rsContact = rs2.getString("contact");
                        rsType = rs2.getString("type");
                        rsIndoor = rs2.getByte("indoor");
                        rsOutdoor = rs2.getByte("outdoor");
                        activitiesList.add(new Activity(rsID, rsName, rsLocation, rsContact, rsType, rsIndoor, rsOutdoor));
                        System.out.println(rs2.getString("name"));
                    }
                } catch (SQLException var10) {
                    System.out.println("An error occurred on executing getOwnedActivities query. p2");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("An error occurred on executing getOwnedActivities query p1");
        }
        return activitiesList;
    }

    public String getEmailRegular(int counter) {
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT email FROM user WHERE iduser = '" + counter + "'"+";");
            while (rs.next()) {
                returnValue = rs.getString("email");

                return returnValue;
            }
        } catch (SQLException var2) {
            System.out.println("An error occurred on fetching regular email query");
        }

        return "";
    }

    public String getPhoneCommer(int counter) {
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT phoneNumber FROM commercialuser WHERE idcommercialUser = '" + counter + "'"+";");
            while (rs.next()) {
                returnValue = rs.getString("phoneNumber");

            }
        } catch (SQLException var2) {
            System.out.println("An error occurred on fetching phone query");
        }

        return returnValue;
    }

    public String getAddressCommer(int counter) {
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT address FROM commercialuser WHERE idcommercialUser = '" + counter + "'"+";");
            while (rs.next()) {
                returnValue = rs.getString("address");
            }
        } catch (SQLException var2) {
            System.out.println("An error occurred on fetching address query");
        }

        return returnValue;
    }

    public int getUsersSize() {
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT COUNT(iduser) FROM user");
            while (rs.next()) {
                returnValueInt = rs.getInt(1);
            }
        } catch (SQLException var1) {
            System.out.println("An error occurred on fetching user size");
        }

        return returnValueInt;
    }

    public String getPasswordRegular(int counter) {
        try {
            ResultSet rs = statement.executeQuery("SELECT password FROM user WHERE iduser = '" + counter + "'"+";");
            while (rs.next()) {
                returnValue = rs.getString(1);
                return returnValue;
            }
        } catch (SQLException var2) {
            System.out.println("An error occurred on fetching password query.");
        }

        return "";
    }

    public String getPasswordCommercial(int counter) {
        try {
            ResultSet rs = statement.executeQuery("SELECT password FROM commercialuser WHERE idcommercialuser = '" + counter + "'"+";");
            if (rs.next()) {
                returnValue = rs.getString("password");
                return returnValue;
            }
        } catch (SQLException var2) {
            System.out.println("An error occurred on fetching password query.");
        }

        return returnValue;
    }


    public static void updateEmail(String email) {

        try {
            statement.executeUpdate("UPDATE user SET email = '" + email + "' WHERE id = " + AuthenticationSingleton.getInstance().getUser().getId());
        } catch (SQLException var7) {
            System.out.println("An error occurred on executing the registration query for updateEmail");
        }
    }

    public static void updateActivity(Activity activity, int activityId) {
        try {
            statement.executeUpdate("UPDATE activity SET (name, location, contact, type, indoor, outdoor) = ('" + activity.getName() + "','" + activity.getLocation() + "','" + activity.getContact()+ "','" + activity.getType() + "','" + activity.getIndoor() + "','" + activity.getOutdoor() + "') WHERE id = " + activityId);
        } catch (SQLException var7) {
            System.out.println("An error occurred on executing the registration query for updateActivity");
        }
    }

    public static void deleteActivity(int idactivity) {

        try {
            statement.executeUpdate("DELETE FROM activity WHERE idactivity = '" + idactivity + "'");
        } catch (SQLException var7) {
            System.out.println("An error occurred on executing the registration query for deleteEmail");
        }
    }

    public void addActivity(String name, String location, String contact, String type, byte indoor, byte outdoor) {
        try {
            statement.executeUpdate("INSERT INTO activity (name, location, contact, type, indoor, outdoor) VALUES ('" + name + "','" + location + "','" + contact + "','" + type + "','" + indoor + "','" + outdoor + "')");
            statement.executeQuery("INSERT INTO commercialuser_has_activity (commercialUser_idcommercialUser, activity_idactivity) VALUES ('" + AuthenticationSingleton.getInstance().getUser().getId() + "','" + DatabaseConnection.getActivityID(name, type) + "')");
        } catch (SQLException var6) {
            System.out.println("An error occurred on executing the adding query for addActivity");
        }
    }


    static void addRating(int userid, String activityid, int rating) {

        try {
            statement.executeQuery("INSERT INTO rating (userid, activityid, rating)VALUES WHERE userid=userid ('" + userid + "','" + activityid + "',''" + rating + "'");
            System.out.println("rating added");
        } catch (SQLException var7) {
            System.out.println();


        }
    }


    public static void addFavorite(int userid, int favouriteid) {

        try {
            statement.executeQuery("INSERT INTO user_has_activity VALUES (" + userid + "," + favouriteid + ",null,null)");
            System.out.println("favorite added");
        } catch (SQLException var7) {
            System.out.println();
        }
    }



    public ObservableList<Activity> browseController() {
        ObservableList<Activity> listForDisplay = FXCollections.observableArrayList();
        try {
            statement = connection.createStatement();
            int rsId;
            String rsName;
            String rsLocation;
            String rsContact;
            String rsType;
            byte rsIndoor;
            byte rsOutdoor;
            ResultSet rs = statement.executeQuery("SELECT * FROM activity");
            while (rs.next()) {
                rsId = rs.getInt("idActivity");
                rsName = rs.getString("name");
                rsLocation = rs.getString("location");
                rsContact = rs.getString("contact");
                rsType = rs.getString("type");
                rsIndoor = rs.getByte("indoor");
                rsOutdoor = rs.getByte("outdoor");

                listForDisplay.add(new Activity(rsId,rsName, rsLocation, rsContact, rsType, rsIndoor, rsOutdoor));
            }
        } catch (SQLException | NullPointerException ex) {
            System.err.println(LocalDateTime.now() + " : " + ex.getMessage());
            System.out.println("An error occurred on executing the query.");
        }
        return listForDisplay;
    }

    public ObservableList<Activity> searchFunctionType(String text) {

        ObservableList<Activity> activitiesList = FXCollections.observableArrayList();
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM activity WHERE type LIKE '%" + text + "%'" + " OR '%" + text + "'" + " OR '" + text + "%'" + ";");
            int rsId;
            String rsName;
            String rsLocation;
            String rsContact;
            String rsType;
            byte rsIndoor;
            byte rsOutdoor;
            while (rs.next()) {
                rsId = rs.getInt("idActivity");
                rsName = rs.getString("name");
                rsLocation = rs.getString("location");
                rsContact = rs.getString("contact");
                rsType = rs.getString("type");
                rsIndoor = rs.getByte("indoor");
                rsOutdoor = rs.getByte("outdoor");
                activitiesList.add(new Activity(rsId,rsName, rsLocation, rsContact, rsType, rsIndoor, rsOutdoor));
            }
        } catch (SQLException var10) {
            System.out.println("An error occurred on executing select query.");
        }
        return activitiesList;
    }

    public ObservableList<Activity> searchFunctionLocation(String text) {

        ObservableList<Activity> activitiesList = FXCollections.observableArrayList();
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM activity WHERE location LIKE '%" + text + "%'" + " OR '%" + text + "'" + " OR '" + text + "%'" + ";");
            int rsId;
            String rsName;
            String rsLocation;
            String rsContact;
            String rsType;
            byte rsIndoor;
            byte rsOutdoor;
            while (rs.next()) {
                rsId = rs.getInt("idActivity");
                rsName = rs.getString("name");
                rsLocation = rs.getString("location");
                rsContact = rs.getString("contact");
                rsType = rs.getString("type");
                rsIndoor = rs.getByte("indoor");
                rsOutdoor = rs.getByte("outdoor");
                activitiesList.add(new Activity(rsId,rsName, rsLocation, rsContact, rsType, rsIndoor, rsOutdoor));
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

    public int getIDRegular(String email) {

        try {
            ResultSet rs = statement.executeQuery("SELECT iduser FROM user WHERE email = '" + email + "'"+";");
            if (rs.next()) {
                returnValue = rs.getString("iduser");
                return returnValueInt;
            }
        } catch (SQLException var2) {
            System.out.println("An error occurred on fetching ID query");


        }

        return returnValueInt;
    }

    public int getIDCommercial(String email) {

        try {
            ResultSet rs = statement.executeQuery("SELECT idcommercialUser FROM commercialuser WHERE email = '" + email + "'"+";");
            if (rs.next()) {
                returnValue = rs.getString(1);
                return returnValueInt;
            }
        } catch (SQLException var2) {
            System.out.println("An error occurred on fetching ID query");


        }

        return 0;
    }

    public String getName(String email) {

        try {
            ResultSet rs = statement.executeQuery("SELECT name FROM commercialuser WHERE email = '" + email + "'"+";");
            if (rs.next()) {
                returnValue = rs.getString(1);
                return returnValue;
            }
        } catch (SQLException var2) {
            System.out.println("An error occurred on fetching ID query");


        }

        return "";
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


            activity = new Activity(id,name, location, contact, type, indoor, outdoor);

        } catch (SQLException var1) {
            System.out.println("An error occurred on executing the query for selectActivity");
        }
        return activity;
    }


    public boolean isInt(TextField input) {

        try {
            int test = Integer.parseInt(input.getText());
            System.out.println("works");
            return true;


        } catch (NumberFormatException e) {
            System.out.println("fails");
            return false;

        }
    }

    public void isString(TextField input) {

        if (!input.getText().matches("[a-zA-Z]+")) {
            System.out.println("only letters");
        } else {
            System.out.println("works");
        }
    }

    public ObservableList<Activity> sortByOutdoor() {

        ObservableList<Activity> activitiesList = FXCollections.observableArrayList();
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM activity WHERE outdoor ='1' ORDER BY name ASC");
            int rsId;
            String rsName;
            String rsLocation;
            String rsContact;
            String rsType;
            byte rsIndoor;
            byte rsOutdoor;
            while (rs.next()) {
                rsId = rs.getInt("idActivity");
                rsName = rs.getString("name");
                rsLocation = rs.getString("location");
                rsContact = rs.getString("contact");
                rsType = rs.getString("type");
                rsIndoor = rs.getByte("indoor");
                rsOutdoor = rs.getByte("outdoor");
                activitiesList.add(new Activity(rsId,rsName, rsLocation, rsContact,rsType, rsIndoor, rsOutdoor));
            }
        } catch (SQLException var10) {
            System.out.println("An error occurred on executing select query.");
        }

        return activitiesList;
    }

    public ObservableList<Activity> sortByIndoor() {

        ObservableList<Activity> activitiesList = FXCollections.observableArrayList();
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM activity WHERE indoor ='1' ORDER BY name ASC");
            int rsId;
            String rsName;
            String rsLocation;
            String rsContact;
            String rsType;
            byte rsIndoor;
            byte rsOutdoor;
            while (rs.next()) {
                rsId = rs.getInt("idActivity");
                rsName = rs.getString("name");
                rsLocation = rs.getString("location");
                rsContact = rs.getString("contact");
                rsType = rs.getString("type");
                rsIndoor = rs.getByte("indoor");
                rsOutdoor = rs.getByte("outdoor");
                activitiesList.add(new Activity(rsId,rsName, rsLocation, rsContact,rsType, rsIndoor, rsOutdoor));
            }
        } catch (SQLException var10) {
            System.out.println("An error occurred on executing select query.");
        }
        return activitiesList;
    }

    public ObservableList<Activity> sortByRFavorite(int userId) {

        ObservableList<Activity> activitiesList = FXCollections.observableArrayList();
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM activity INNER JOIN user_has_activity ON user_has_activity.activity_idactivity=activity.idactivity WHERE" + " user_has_activity.user_iduser=" + userId + ";");
            int rsId;
            String rsName;
            String rsLocation;
            String rsContact;
            String rsType;
            byte rsIndoor;
            byte rsOutdoor;
            while (rs.next()) {
                rsId = rs.getInt("idaactivity");
                rsName = rs.getString("name");
                rsLocation = rs.getString("location");
                rsContact = rs.getString("contact");
                rsType = rs.getString("type");
                rsIndoor = rs.getByte("indoor");
                rsOutdoor = rs.getByte("outdoor");
                activitiesList.add(new Activity(rsId,rsName, rsLocation, rsContact, rsType, rsIndoor, rsOutdoor));
            }
        } catch (SQLException var10) {
            System.out.println("An error occurred on executing query.");
            var10.printStackTrace();
        }

        return activitiesList;
    }

    public ObservableList<Activity> searchFunctionName(String text) {

        ObservableList<Activity> activitiesList = FXCollections.observableArrayList();
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM activity WHERE name LIKE '%" + text + "%'" + " OR '%" + text + "'" + " OR '" + text + "%'" + ";");
            int rsId;
            String rsName;
            String rsLocation;
            String rsContact;
            String rsType;
            byte rsIndoor;
            byte rsOutdoor;
            while (rs.next()) {
                rsId = rs.getInt("idactivity");
                rsName = rs.getString("name");
                rsLocation = rs.getString("location");
                rsContact = rs.getString("contact");
                rsType = rs.getString("type");
                rsIndoor = rs.getByte("indoor");
                rsOutdoor = rs.getByte("outdoor");
                activitiesList.add(new Activity(rsId,rsName, rsLocation, rsContact, rsType, rsIndoor, rsOutdoor));
            }
        } catch (SQLException var10) {
            System.out.println("An error occurred on executing search query.");
        }

        return activitiesList;
    }

    public ObservableList<Activity> shuffleList(ObservableList<Activity> activityList) {

        ObservableList<Activity> list = FXCollections.observableArrayList();

        for (Activity i : activityList) {
            list.add(i);
        }
        Collections.shuffle(list);
        activityList = list;
        return activityList;
    }


}



