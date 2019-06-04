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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;


public class SignUpController extends AbstractController implements Initializable {

    @FXML
    private Button home;
    @FXML
    private Button commercialSign;
    @FXML
    private Button regularSign;
    @FXML
    private TextField emailField;
    @FXML
    private TextField passField;
    @FXML
    private TextField confirmpassField;



    @FXML
    private void toLogin(ActionEvent event) throws IOException {
        changeScene(event, "../views/loginView.fxml");
    }

    @FXML
    private void emailTF(ActionEvent event) {

    }
    @FXML
    private void passTF(ActionEvent event) {

    }
    @FXML
    private void confirmpassTF(ActionEvent event) {

    }
    @FXML
    private void signUpCommer(ActionEvent event) {

    }
    @FXML
    private void signUpRegular(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

















}
