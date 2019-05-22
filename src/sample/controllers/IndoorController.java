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
import sample.utils.DatabaseConnection;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import static sample.utils.DatabaseConnection.DB_Connection;
import static sample.utils.DatabaseConnection.selectActivities;
import static sample.utils.DatabaseConnection.showActivity;

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
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../views/browseView.fxml"));
            try {

                loader.load();
        }catch (IOException e){
            e.printStackTrace();
        }

        BrowseController browseController = loader.getController();
        browseController.recieveFunction(DatabaseConnection.selectActivities("badminton"));
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

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

    }
    @FXML
    private void toSquash(ActionEvent event) throws IOException {
        changeScene(event, "../views/browseView.fxml");
        DatabaseConnection.showActivity("squash");
    }


}

