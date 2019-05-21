package sample.utils;

import sample.Main;

import java.sql.*;
import java.util.Properties;

public class DatabaseConnection {

    static Statement statement;
    static String returnValue;
    static int returnValueInt;
    static int[] returnValueArr;
    //"jdbc:mysql://localhost:3306/project_2";

    private Properties properties;
    private Connection connection;

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
                System.out.println(rs.getString(4));
            }
        } catch (SQLException var2) {
            System.out.println("An error occurred on executing the query.");
        }

    }

    public static String getUsername(int counter) {
        try {
            ResultSet rs = statement.executeQuery("SELECT username FROM user WHERE id = " + counter);
            if (rs.next()) {
                returnValue = rs.getString(1);
                return returnValue;
            }
        } catch (SQLException var2) {
            System.out.println("An error occurred on executing the query.");
        }

        return "";
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

    public void updateEmail(String email){
        try {
            statement.executeUpdate("UPDATE user SET email = '" + email + "' WHERE username = " + main.getLoggedInUser().getUsername());
        } catch (SQLException var7) {
            System.out.println("An error occurred on executing the registration query.");
        }
    }

    static void addActivity(String name, String location, String contact, String type, boolean indoor, boolean outdoor) {
        try {
            statement.executeUpdate("INSERT INTO activity (name, location, contact, type, indoor, outdoor) VALUES ('" + name + "','" + location + "','" + contact + "','" + type + "','"+ indoor + "','" + outdoor + "'");
            System.out.println("Book added.");
        } catch (SQLException var6) {
            System.out.println("An error occurred on executing the adding query.");
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

    public static int[] getFavourites(int counter) {
        try {
            ResultSet rs = statement.executeQuery("SELECT favourite FROM user WHERE id = " + counter);
            if (rs.next()) {
                returnValue = rs.getString(1);
                return returnValueArr;
            }
        } catch (SQLException var2) {
            System.out.println("An error occurred on executing the query.");
        }

        return returnValueArr;
    }

    public static int getFavoriteSize() {
        DB_Connection();

        try {
            ResultSet rs = statement.executeQuery("SELECT COUNT(favouriteid) FROM users");
            if (rs.next()) {
                returnValueInt = rs.getInt(1);
                return returnValueInt;
            }
        } catch (SQLException var1) {
            System.out.println("An error occurred on executing the query.");
        }

        return 0;
    }



}

