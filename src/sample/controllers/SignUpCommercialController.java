package sample.controllers;

import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.model.Activity;


import sample.*;
import sample.model.User;
import sample.utils.AuthenticationSingleton;
import sample.utils.DatabaseConnection;
import sample.utils.PdfFormatter;


import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.*;


public class SignUpCommercialController extends AbstractController implements Initializable {

    @FXML
    private TextField emailField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField phonenumberField;
    @FXML
    private TextField passField;
    @FXML
    private TextField confirmpassField;

    private String email, name, address, password, confirmPassword;

   private ObservableList<String> compareList = FXCollections.observableArrayList();


    @FXML
    private void toLogin(ActionEvent event) throws IOException {
        changeScene(event, "../views/loginView.fxml");
    }

    @FXML
    private void signUpCommercial(ActionEvent event) {
        DatabaseConnection db = new DatabaseConnection();
        boolean a = true;
        boolean b = true;
        boolean c= true;
        boolean d = true;
        if(!emailField.getText().isEmpty() && !passField.getText().isEmpty() && !nameField.getText().isEmpty() && !addressField.getText().isEmpty() && !phonenumberField.getText().isEmpty()){
            email = emailField.getText();
            password = passField.getText();
            confirmPassword = confirmpassField.getText();
            if(email.contains(" ") || password.contains(" ") || confirmPassword.contains(" ")){
                Alert alert = new Alert(Alert.AlertType.WARNING,"Spacebar is unacceptable!");
                alert.show();
                passField.setText("");
                confirmpassField.setText("");
                a = false;
            }
            else if(!confirmPassword.equals(password)){
                Alert alert = new Alert(Alert.AlertType.WARNING,"Password must match!");
                alert.show();
                passField.setText("");
                confirmpassField.setText("");
                b = false;
            }
            else if(!email.contains("@") && !email.contains(".")){
                Alert alert = new Alert(Alert.AlertType.WARNING,"Make sure email is correct!");
                alert.show();
                emailField.setText("");
                passField.setText("");
                confirmpassField.setText("");
                c = false;
            }
            else{
                compareList = db.getAllCommercialEmail();
            }
            for(int i=0; i < compareList.size();i++){
                if(compareList.get(i).equals(email)){
                    Alert alert = new Alert(Alert.AlertType.WARNING,"This email already exist!");
                    alert.show();
                    d = false;
                }
            }
            if(a && b && c && d){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Wait a sec...");
                alert.setHeaderText(null);
                alert.setContentText("Confirm register");
                Optional<ButtonType> action = alert.showAndWait();
                if(action.get() == ButtonType.OK) {
                    try {
                        db.addCommercialUser(emailField.getText(), confirmpassField.getText(), nameField.getText(), addressField.getText(), phonenumberField.getText());
                        emailField.setText("");
                        passField.setText("");
                        confirmpassField.setText("");
                        nameField.setText("");
                        addressField.setText("");
                        phonenumberField.setText("");
                        changeScene(event, "../views/loginView.fxml");
                    } catch (Exception e) {
                        System.out.println("Something went wrong!");
                    }
                }
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING,"Try again!");
                alert.show();
                emailField.setText("");
                passField.setText("");
                confirmpassField.setText("");
            }
        }
        else if(emailField.getText().isEmpty() || passField.getText().isEmpty() || confirmpassField.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING,"Make sure the fields has input");
            alert.show();
            passField.setText("");
            confirmpassField.setText("");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }















}
