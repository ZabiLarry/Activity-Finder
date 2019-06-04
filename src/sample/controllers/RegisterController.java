package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.w3c.dom.Text;
import sample.utils.DatabaseConnection;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController extends AbstractController implements Initializable {



    @FXML
    private TextField emailRegular;

    @FXML
    private PasswordField passRegular;

    @FXML
    private Button okRegular;

    @FXML
    private Button registerCancel;

    @FXML
    private TextField emailCom;

    @FXML
    private TextField nameCom;

    @FXML
    private TextField passCom;

    @FXML
    private TextField addressCom;

    @FXML
    private TextField nrCom;

    @FXML
    private Button okCom;






    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }




    public void registerRegular(){

        DatabaseConnection.addUser(passRegular.getText(), emailRegular.getText());

        System.out.println("registered regular user");



    }


    public void registerCommercial(){

        DatabaseConnection.addCommercial(emailCom.getText(), passCom.getText(), nameCom.getText(), addressCom.getText(), Integer.parseInt(nrCom.getText()));
        System.out.println("registered regular user");

    }


    @FXML
    private void toLogin(ActionEvent event) throws IOException {
        changeScene(event, "../views/loginView.fxml");

    }
}
