package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import sample.utils.AuthenticationSingleton;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class HelpController extends AbstractController implements Initializable {

    @FXML
    private void toHome(ActionEvent event) throws IOException {
        changeScene(event, "../views/homePageView.fxml");
    }

    @FXML
    private void toBrowse(ActionEvent event) throws IOException {
        changeScene(event, "../views/browseView.fxml");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
