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
import sample.Main;
import sample.model.RegularUser;
import sample.model.User;
import sample.utils.DatabaseConnection;

import javax.xml.crypto.Data;

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

    Main main = new Main();

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




    //login  method that creates an object
    public void login(){

        int counter;
        for(counter =0; counter<= DatabaseConnection.getUsersSize() + 1; ++counter){
            if(txtUserName.getText().equals(DatabaseConnection.getEmail(counter))){
                if(txtPassword.getText().equals(DatabaseConnection.getPassword(counter)))
                { System.out.println("login success");
                RegularUser user = new RegularUser(DatabaseConnection.getEmail(counter), DatabaseConnection.getPassword(counter));
                main.setLoggedInUser(user);


            }
            else{ System.out.println("failed");

                }

        }
    }
}

public int[] favourites(){


        int[] fav ={};
        return fav;

}


}



