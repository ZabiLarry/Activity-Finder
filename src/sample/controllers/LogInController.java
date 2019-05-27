package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.utils.DatabaseConnection;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LogInController extends AbstractController {
    @FXML
    private Label lblStatus;//

    @FXML
    private TextField txtUserName;

    @FXML
    private TextField txtPassword;


    public void login(ActionEvent event) throws IOException {
        if (txtUserName.getText().equals("User") && txtPassword.getText().equals("pass")) {
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


    //login  method that creates an object
    public void logOnto() {
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
    }

    public void forgotPass(ActionEvent event) {

        try {
            changeScene(event, "/views/forgotPasswordView.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int[] favourites() {


        int[] fav = {};
        return fav;

    }


}



