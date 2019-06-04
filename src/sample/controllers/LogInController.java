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

        DatabaseConnection db = new DatabaseConnection();
        email = emailTF.getText();
        int counter;
        for (counter = 1; counter <= db.getUsersSize() + 1; ++counter)
            if (email.equals(db.getEmailRegular(counter))) {
                if (passwordTF.getText().equals(db.getPasswordRegular(counter))) {
                    System.out.println("loginRegular success");
                    RegularUser user = new RegularUser(db.getEmailRegular(counter), db.getIDRegular(email));
                    lblStatus.setText("Login Success");
                    AuthenticationSingleton.getInstance().setUser(user);

                    homePage(event);
                    break;
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "loginRegular failed", ButtonType.OK);
                lblStatus.setText("Login Failed");
            }
    }

    public void loginCommercial(ActionEvent event) throws IOException {

        int one = 1;
        DatabaseConnection db = new DatabaseConnection();
        email = emailTF.getText();
        int counter;
        for (counter = 1; counter <= db.getUsersSize() + 1; counter++) {

            if (Objects.equals(email, db.getEmailCommercial(counter))) {
                if (Objects.equals(passwordTF.getText(), db.getPasswordCommercial(counter))) {
                    System.out.println("loginCommercial success");
                    CommercialUser user = new CommercialUser(db.getEmailCommercial(counter), db.getIDCommercial(email), db.getName(email), db.getPhoneCommer(one), db.getAddressCommer(one));
                    lblStatus.setText("Login Success");
                    AuthenticationSingleton.getInstance().setUser(user);
                    homePage(event);
                    break;
                } else {
                    System.out.println("failed password retrieve");
                }
            } else {
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

    public void signUp(ActionEvent event) {
        try {
            changeScene(event, "../views/signUp.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void signUpCommercial(ActionEvent event) {
        try {
            changeScene(event, "../views/signUpCommercial.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




