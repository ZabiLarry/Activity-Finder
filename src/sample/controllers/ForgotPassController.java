package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
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
        String name = "name";
        String  pass = "pass";

        MailSender.sendForgottenPassword(email,name,pass);
    }

    public void goHome(ActionEvent event){
        try {
            homePage(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

