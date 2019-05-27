package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.Main;
import sample.model.Activity;
import sample.model.RegularUser;
import sample.utils.DatabaseConnection;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LogInController extends AbstractController {
    @FXML
    private Label lblStatus;//

    @FXML
    private TextField emailTF;

    @FXML
    private TextField passwordTF;

    Main main = new Main();

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
    public void login() {

        if (passwordTF.getText().equals(DatabaseConnection.logInVerification(emailTF.getText()))){

            RegularUser user = new RegularUser(emailTF.getText(), Integer.parseInt(DatabaseConnection.getID(emailTF.getText())), DatabaseConnection.getFavorites(DatabaseConnection.getID(emailTF.getText())));
            main.setLoggedInUser(user);

        }else {
            lblStatus.setText("Wrong Password");
        }

    }




}



