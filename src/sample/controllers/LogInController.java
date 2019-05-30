package sample.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.Main;
import sample.model.*;
import sample.utils.AuthenticationSingleton;
import sample.utils.DatabaseConnection;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.model.RegularUser;

import java.io.IOException;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class LogInController extends AbstractController {
    @FXML
    private Label lblStatus;//

    @FXML
    private TextField emailTF;

    @FXML
    private PasswordField passwordTF;

    Main main;

    String email;

    /*public void login() {

        main = new Main();

        if (passwordTF.getText().equals(DatabaseConnection.logInVerification(email))) {

<<<<<<< HEAD
            RegularUser user = new RegularUser(email, Integer.parseInt(DatabaseConnection.getID(email)), (ArrayList<Activity>) DatabaseConnection.getFavorites(DatabaseConnection.getID(email)));
=======
            RegularUser user = new RegularUser(email, DatabaseConnection.getID(email)*//*, DatabaseConnection.getFavorites(DatabaseConnection.getID(email))*//*);
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

    public void loginRegular(ActionEvent event) throws IOException {

        email = emailTF.getText();
        int counter;
        for (counter = 1; counter <= DatabaseConnection.getUsersSize() + 1; ++counter) {
            if (email.equals(DatabaseConnection.getEmailRegular(counter))) {
                if (passwordTF.getText().equals(DatabaseConnection.getPasswordRegular(counter))) {
                    System.out.println("loginRegular success");
                    RegularUser user = new RegularUser(DatabaseConnection.getEmailRegular(counter), DatabaseConnection.getIDRegular(email));
                    lblStatus.setText("Login Success");

                    AuthenticationSingleton.getInstance().setUser(user);
                    homePage(event);
                }
            } else {
                System.out.println("failed");
                Alert alert = new Alert(Alert.AlertType.ERROR, "loginRegular failed", ButtonType.OK);
                lblStatus.setText("Login Failed");
            }
        }
    }

    public void loginCommercial(ActionEvent event) throws IOException {

        email = emailTF.getText();
        int counter;
        for (counter = 1; counter <= DatabaseConnection.getUsersSize() + 1; ++counter) {

            if (Objects.equals(email, DatabaseConnection.getEmailCommercial(counter))) {
                if (Objects.equals(passwordTF.getText(), DatabaseConnection.getPasswordCommercial(counter))) {
                    System.out.println("loginCommercial success");
                    CommercialUser user = new CommercialUser(DatabaseConnection.getEmailCommercial(counter), DatabaseConnection.getIDCommercial(email), DatabaseConnection.getName(email), DatabaseConnection.getPhone(counter), DatabaseConnection.getAddress(counter));
                    lblStatus.setText("Login Success");
                    AuthenticationSingleton.getInstance().setUser(user);
                    homePage(event);
                } else {
                    System.out.println("failed password retrieve");
                }
            } else {
                System.out.println("failed to get email");
                Alert alert = new Alert(Alert.AlertType.ERROR, "loginCommercial failed", ButtonType.OK);
                lblStatus.setText("Login Failed");
            }
        }
    }

    public void forgotPass(ActionEvent event) {
        try {
            changeScene(event, "../views/forgotPasswordView.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}





