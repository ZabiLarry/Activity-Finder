package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.utils.DatabaseConnection;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController extends AbstractController implements Initializable {



    @FXML
    private TextField emailRegField;

    @FXML
    private PasswordField passReggie;

    @FXML
    private Button registerOK;

    @FXML
    private Button registerCancel;




    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }




    public void registerOK(){




    }

}
