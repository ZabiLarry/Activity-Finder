package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import sample.utils.DatabaseConnection;
import sample.utils.MailSender;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ForgotPassController extends AbstractController implements Initializable {
    @FXML
    private TextField emailField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void sendPass(ActionEvent event){
        String email  = emailField.getText();
        DatabaseConnection db = new DatabaseConnection();
        String name = "Anonymous";
        String  pass = db.forgottenPassword(email);

        if(pass == null){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Email not registered", ButtonType.OK );
            alert.showAndWait();
            return;
        }
        MailSender.sendForgottenPassword(email,name,pass);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Password sent", ButtonType.OK );
        alert.showAndWait();

    }

    public void goHome(ActionEvent event){
        try {
            changeScene(event, "../views/loginView.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

