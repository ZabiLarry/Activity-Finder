package sample.controllers;


import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.Main;
import sample.model.Activity;
import sample.model.RegularUser;
import sample.utils.AuthenticationSingleton;
import sample.utils.DatabaseConnection;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.Main;
import sample.model.Activity;
import sample.model.RegularUser;
import sample.model.User;
import sample.utils.DatabaseConnection;

import java.io.IOException;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LogInController extends AbstractController {
    @FXML
    private Label lblStatus;//

    @FXML
    private TextField emailTF;

    @FXML
    private PasswordField passwordTF;

    Main main;

    /*public void login() {

        main = new Main();

        if (passwordTF.getText().equals(DatabaseConnection.logInVerification(emailTF.getText()))) {

<<<<<<< HEAD
            RegularUser user = new RegularUser(emailTF.getText(), Integer.parseInt(DatabaseConnection.getID(emailTF.getText())), (ArrayList<Activity>) DatabaseConnection.getFavorites(DatabaseConnection.getID(emailTF.getText())));
=======
            RegularUser user = new RegularUser(emailTF.getText(), DatabaseConnection.getID(emailTF.getText())*//*, DatabaseConnection.getFavorites(DatabaseConnection.getID(emailTF.getText()))*//*);
>>>>>>> master
            main.setLoggedInUser(user);

        } else {
            lblStatus.setText("Wrong Password");
        }

    }*/

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        main = new Main();
    }


    //login  method that creates an object

  public void login(ActionEvent event) throws IOException {


        int counter;
        for(counter =0; counter<= DatabaseConnection.getUsersSize() + 1; ++counter){
            if(emailTF.getText().equals(DatabaseConnection.getEmail(counter))){
                if(passwordTF.getText().equals(DatabaseConnection.getPassword(counter))) {
                    System.out.println("login success");
                    RegularUser user = new RegularUser(DatabaseConnection.getEmail(counter), DatabaseConnection.getID(emailTF.getText()));
                    lblStatus.setText("Login Success");

                    AuthenticationSingleton.getInstance().setUser(user);

                    homePage(event);
                }



                } else {
                    System.out.println("failed");
                    Alert alert = new Alert(Alert.AlertType.ERROR, "login failed", ButtonType.OK);
                    lblStatus.setText("Login Failed");


                }


        }
    }

    public void forgotPass(ActionEvent event) {

        try {
            changeScene(event, "/views/forgotPasswordView.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}





