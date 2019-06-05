package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.Main;
import sample.model.CommercialUser;
import sample.model.RegularUser;
import sample.utils.AuthenticationSingleton;
import sample.utils.DatabaseConnection;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class SettingsController extends AbstractController{



    @FXML
    TextField emailTF;

    @FXML
    TextField phoneTF;

    @FXML
    TextField addressTF;

    @FXML
    PasswordField passwordTF;

    @FXML
    Button goToEditBTN;

    @FXML
    Label updatelbl;


    @FXML
    private void changeEmail(){

        DatabaseConnection.updateEmail(emailTF.getText(), passwordTF.getText());
        if (DatabaseConnection.updateEmail(emailTF.getText(), passwordTF.getText())) {
            updatelbl.setVisible(true);
            updatelbl.setText("Data updated");
        }else {
            updatelbl.setVisible(true);
            updatelbl.setText("Wrong password");
        }
    }
    

    @FXML
    private void toHome(ActionEvent event) throws IOException {
        homePage(event);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        phoneTF.setVisible(false);
        addressTF.setVisible(false);

        if (Objects.equals(String.valueOf(AuthenticationSingleton.getInstance().getUser().getClass()), "class sample.model.CommercialUser")){
            System.out.println("is commercial");
            phoneTF.setDisable(false);
            addressTF.setDisable(false);
            goToEditBTN.setDisable(false);
            emailTF.setText(AuthenticationSingleton.getInstance().getUser().getEmail());
        }else{
            System.out.println("is not commercial" );
            emailTF.setText(AuthenticationSingleton.getInstance().getUser().getEmail());
        }

    }


    @FXML
    private void toEditActivities(ActionEvent event) throws IOException {
        changeScene(event, "../views/activityEditView.fxml");
    }



}
