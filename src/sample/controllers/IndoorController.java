package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.DatabaseConnection;

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
        changeScene(event, "../views/homePageView.fxml");

    }
    @FXML
    private void toBadminton(ActionEvent event) throws IOException {
        changeScene(event, "../views/browseView.fxml");
        DatabaseConnection.showActivity("badminton");

    }
    @FXML
    private void toVolleyball(ActionEvent event) throws IOException {
        changeScene(event, "../views/browseView.fxml");
        DatabaseConnection.showActivity("volleyball");
    }
    @FXML
    private void toSoccer(ActionEvent event) throws IOException {
        changeScene(event, "../views/browseView.fxml");
        DatabaseConnection.showActivity("soccer");
    }
    @FXML
    private void toBoxing(ActionEvent event) throws IOException {
        changeScene(event, "../views/browseView.fxml");
        DatabaseConnection.showActivity("boxing");
    }
    @FXML
    private void toFitness(ActionEvent event) throws IOException {
        changeScene(event, "../views/browseView.fxml");

        Singleton fitness = null;
        fitness.getInstance();
    }
    @FXML
    private void toSquash(ActionEvent event) throws IOException {
        changeScene(event, "../views/browseView.fxml");
        DatabaseConnection.showActivity("squash");
    }


}

