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
import sample.utils.DatabaseConnection;

public class LogInController {
    @FXML
    private Label lblStatus;

    @FXML
    private TextField txtUserName;

    @FXML
    private TextField txtPassword;

    public void login(ActionEvent event) {
        if (txtUserName.getText().equals("User")&& txtPassword.getText().equals("pass")) {
            lblStatus.setText("Login Success");
        } else {
         //   lblStatus.setText("Login Failed");

            Alert alert = new Alert(Alert.AlertType.ERROR, "login failed", ButtonType.OK);
            alert.showAndWait();

        }
    }

    public void logOnto(){
        for(int counter =0; counter<= DatabaseConnection.getUsersSize() + 1; ++counter){
            if(txtUserName.getText().equals(DatabaseConnection.getUsername(counter))){
                if(txtPassword.getText().equals(DatabaseConnection.getPassword(counter)))
                { System.out.println("login success");
            }

        }
    }
}

public int[] favourites(){


        int[] fav ={};
        return fav;
}


}



