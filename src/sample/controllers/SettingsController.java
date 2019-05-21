package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Main;
import sample.model.CommercialUser;
import sample.utils.DatabaseConnection;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController extends AbstractController{



    @FXML
    TextField emailTF;

    @FXML
    TextField nameTF;

    @FXML
    TextField locationTF;

    @FXML
    TextField typeTF;

    @FXML
    ChoiceBox inCheck;

    @FXML
    ChoiceBox outCheck;

    Main main = new Main();

    @FXML
    private void toHome(ActionEvent event) throws IOException {
        homePage(event);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    private void updateEmail(){
        //databaseconnection updateemail()

    }

    private void addActivity(){

        //databaseconnection addActivity(nameTF.getText(), locationTF.getText(), main.getLoggedInUser().getEmail(), typeTF.getText(), inCheck.isSelected(), outCheck.isSelected())
    }

}
