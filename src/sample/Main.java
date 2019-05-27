package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import sample.controllers.LogInController;
import sample.model.User;

import sample.model.Activity;

import sample.utils.DatabaseConnection;
import sample.utils.MailSender;
import sample.utils.PdfFormatter;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("views/homePageView.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();


        // to connect to databse initialize DatabseConnection object and then call methods to fetch data and close the
        // connection after last query/method was executed.
        DatabaseConnection db = new DatabaseConnection();
        // pdf test
        PdfFormatter.createPDF("myPDF.pdf", "I really like this application");



        /*ArrayList<Activity> activities = new ArrayList();
        do {
            activities.add(new Activity());
        }*/

        // mail test
     //   MailSender.sendForgottenPassword("karl.i.lundh@gmail.com", "karl", "test");

    }


    public static void main(String[] args) {
        launch(args);

    }

    private User loggedInUser;

    public void setLoggedInUser(User user){
        this.loggedInUser = user;

    }

    public User getLoggedInUser(){
        return loggedInUser;
    }
}
