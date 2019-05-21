package sample.controllers;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LogInController extends AbstractController {
    @FXML
    private Label lblStatus;

    @FXML
    private TextField txtUserName;

    @FXML
    private TextField txtPassword;

    public void login(ActionEvent event) throws IOException {
        if (txtUserName.getText().equals("User")&& txtPassword.getText().equals("pass")) {
            lblStatus.setText("Login Success");
            homePage(event);
            //to add setLoggedInUser()
        } else {
           lblStatus.setText("Login Failed");

            Alert alert = new Alert(Alert.AlertType.ERROR, "login failed", ButtonType.OK);
            alert.showAndWait();

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
