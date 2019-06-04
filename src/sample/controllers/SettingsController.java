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
import java.util.Optional;
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

    private String email,phone,address,password;





    @FXML
    private void changeInfoCommer(){

        DatabaseConnection db = new DatabaseConnection();
        boolean a = true;
        boolean b= true;
        if(!emailTF.getText().isEmpty() && !phoneTF.getText().isEmpty() && !addressTF.getText().isEmpty() && !passwordTF.getText().isEmpty()){
            email = emailTF.getText();
            password = passwordTF.getText();
            phone = phoneTF.getText();
            address = passwordTF.getText();
            if(email.contains(" ") || password.contains(" ") || phone.contains(" ") || address.contains(" ")){
                Alert alert = new Alert(Alert.AlertType.WARNING,"Spacebar is unacceptable!");
                alert.show();
                emailTF.setText("");
                phoneTF.setText("");
                addressTF.setText("");
                passwordTF.setText("");
                a = false;
            }
            else if(!email.contains("@") && !email.contains(".")){
                Alert alert = new Alert(Alert.AlertType.WARNING,"Make sure email is correct!");
                alert.show();
                emailTF.setText("");
                phoneTF.setText("");
                passwordTF.setText("");
                addressTF.setText("");
                b = false;
            }
            if(a && b){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Wait a sec...");
                alert.setHeaderText(null);
                alert.setContentText("Confirm change");
                Optional<ButtonType> action = alert.showAndWait();
                if(action.get() == ButtonType.OK) {
                    try {
                        db.updateComemerEmail(email);
                        db.updateCommerAddress(address);
                        db.updateCommerPhone(phone);
                        db.updateCommerPassword(password);
                        emailTF.setText("");
                        addressTF.setText("");
                        phoneTF.setText("");
                        passwordTF.setText("");
                        System.out.println("information updated");
                    } catch (Exception e) {
                        System.out.println("Something went wrong!");
                    }
                }
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING,"Try again!");
                alert.show();
                emailTF.setText("");
                addressTF.setText("");
                phoneTF.setText("");
                passwordTF.setText("");
            }
        }
        else if(emailTF.getText().isEmpty() || addressTF.getText().isEmpty() || phoneTF.getText().isEmpty() || passwordTF.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING,"Make sure the fields has input");
            alert.show();
            emailTF.setText("");
            addressTF.setText("");
            phoneTF.setText("");
            passwordTF.setText("");
        }
    }

    @FXML
    private void changeInfoRegu(){

        DatabaseConnection db = new DatabaseConnection();
        boolean a = true;
        boolean b= true;
        if(!emailTF.getText().isEmpty() && !passwordTF.getText().isEmpty()){
            email = emailTF.getText();
            password = passwordTF.getText();
            if(email.contains(" ") || password.contains(" ")){
                Alert alert = new Alert(Alert.AlertType.WARNING,"Spacebar is unacceptable!");
                alert.show();
                emailTF.setText("");
                passwordTF.setText("");
                a = false;
            }
            else if(!email.contains("@") && !email.contains(".")){
                Alert alert = new Alert(Alert.AlertType.WARNING,"Make sure email is correct!");
                alert.show();
                emailTF.setText("");
                passwordTF.setText("");
                b = false;
            }
            if(a && b){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Wait a sec...");
                alert.setHeaderText(null);
                alert.setContentText("Confirm change");
                Optional<ButtonType> action = alert.showAndWait();
                if(action.get() == ButtonType.OK) {
                    try {
                        db.updateReguEmail(email);
                        db.updateReguPassword(password);
                        emailTF.setText("");
                        passwordTF.setText("");
                        System.out.println("information updated");
                    } catch (Exception e) {
                        System.out.println("Something went wrong!");
                    }
                }
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING,"Try again!");
                alert.show();
                emailTF.setText("");
                passwordTF.setText("");
            }
        }
        else if(emailTF.getText().isEmpty() || passwordTF.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING,"Make sure the fields has input");
            alert.show();
            emailTF.setText("");
            passwordTF.setText("");
        }
    }

    @FXML
    private void toHome(ActionEvent event) throws IOException {
        homePage(event);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (Objects.equals(String.valueOf(AuthenticationSingleton.getInstance().getUser().getClass()), "class sample.model.CommercialUser")){
            System.out.println("is commercial");
            phoneTF.setDisable(false);
            addressTF.setDisable(false);
            goToEditBTN.setDisable(false);
        }else{
            System.out.println("is not commercial" );
        }

    }


    @FXML
    private void toEditActivities(ActionEvent event) throws IOException {
        changeScene(event, "../views/activityEditView.fxml");
    }



}
