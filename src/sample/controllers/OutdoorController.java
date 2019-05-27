package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.utils.DatabaseConnection;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class OutdoorController extends AbstractController implements Initializable {


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    @FXML
    private void toHome(ActionEvent event) throws IOException {
        homePage(event);
    }
    @FXML
    private void toKajak(ActionEvent event) throws IOException {
        changeScene(event, "../views/browseView.fxml");
        DatabaseConnection.showActivity("kajak");
    }
    @FXML
    private void toClimbing(ActionEvent event) throws IOException {
        changeScene(event, "../views/browseView.fxml");
        DatabaseConnection.showActivity("climbing");
    }
    @FXML
    private void toSwimming(ActionEvent event) throws IOException {
        changeScene(event, "../views/browseView.fxml");
        DatabaseConnection.showActivity("swimming");
    }
    @FXML
    private void toFishing(ActionEvent event) throws IOException {
        changeScene(event, "../views/browseView.fxml");
        //DatabaseConnection.showActivity("fishing");
    }
    @FXML
    private void toAdventure(ActionEvent event) throws IOException {
        changeScene(event, "../views/browseView.fxml");
        DatabaseConnection.showActivity("adventure");
    }
    @FXML
    private void toSomething(ActionEvent event) throws IOException {
        changeScene(event, "../views/browseView.fxml");
        DatabaseConnection.showActivity("Something");
    }

}
