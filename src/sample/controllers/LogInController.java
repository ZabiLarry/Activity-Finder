package sample.controllers;


import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.Main;
import sample.model.Activity;
import sample.model.RegularUser;
import sample.utils.DatabaseConnection;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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


    public void login() {

        Main main = new Main();

        if (passwordTF.getText().equals(DatabaseConnection.logInVerification(emailTF.getText()))) {

            RegularUser user = new RegularUser(emailTF.getText(), Integer.parseInt(DatabaseConnection.getID(emailTF.getText())), (ArrayList<Activity>) DatabaseConnection.getFavorites(DatabaseConnection.getID(emailTF.getText())));
            main.setLoggedInUser(user);

        } else {
            lblStatus.setText("Wrong Password");
        }

    }

    /*public void login(ActionEvent event) throws IOException {
        if (txtUserName.getText().equals("User") && txtPassword.getText().equals("pass")) {
            lblStatus.setText("Login Success");
            homePage(event);
            //to add setLoggedInUser()
        } else {
            lblStatus.setText("Login Failed");

            Alert alert = new Alert(Alert.AlertType.ERROR, "login failed", ButtonType.OK);
            alert.showAndWait();

        }
    }*/

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    //login  method that creates an object




    /*public void logOnto() {
        for (int counter = 0; counter <= DatabaseConnection.getUsersSize() + 1; ++counter) {
            if (txtUserName.getText().equals(DatabaseConnection.getUsername(counter))) {
                if (txtPassword.getText().equals(DatabaseConnection.getPassword(counter))) {
                    System.out.println("login success");

                    //RegularUser user = new RegularUser(txtUserName.getText(), "w/e");


                } else {
                    System.out.println("failed");

                }

            }
        }
    }*/

    public void forgotPass(ActionEvent event) {

        try {
            changeScene(event, "/views/forgotPasswordView.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}




