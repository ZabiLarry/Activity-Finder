package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.BackInterface;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class IndoorController extends AbstractController implements Initializable {


    private void initialize(){

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void toHome(ActionEvent event) throws IOException {
       homePage(event);
    }
}
