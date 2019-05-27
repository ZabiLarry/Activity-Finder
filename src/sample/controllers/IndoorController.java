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



public class IndoorController extends AbstractController implements Initializable {

    DatabaseConnection dbconnect = new DatabaseConnection();


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
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/browseView.fxml"));
        Parent root = (Parent) loader.load();
        BrowseController browseController = loader.getController();
        browseController.recieveFunction(dbconnect.selectActivities("badminton"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @FXML
    private void toVollyball(ActionEvent event) throws IOException {
        changeScene(event, "../views/browseView.fxml");

    }
    @FXML
    private void toSoccer(ActionEvent event) throws IOException {
        changeScene(event, "../views/browseView.fxml");

    }
    @FXML
    private void toBoxing(ActionEvent event) throws IOException {
        changeScene(event, "../views/browseView.fxml");

    }
    @FXML
    private void toBoxercise(ActionEvent event) throws IOException {
        changeScene(event, "../views/browseView.fxml");

    }
    @FXML
    private void toThaiBoxing(ActionEvent event) throws IOException {
        changeScene(event, "../views/browseView.fxml");

    }
    @FXML
    private void toBasketball(ActionEvent event) throws IOException {
        changeScene(event, "../views/browseView.fxml");

    }
    @FXML
    private void toJuJitsui(ActionEvent event) throws IOException {
        changeScene(event, "../views/browseView.fxml");

    }
    @FXML
    private void toClimbing(ActionEvent event) throws IOException {
        changeScene(event, "../views/browseView.fxml");

    }
    @FXML
    private void toPaddleball(ActionEvent event) throws IOException {
        changeScene(event, "../views/browseView.fxml");

    }
    @FXML
    private void toSwimming(ActionEvent event) throws IOException {
        changeScene(event, "../views/browseView.fxml");

    }
    @FXML
    private void toSquash(ActionEvent event) throws IOException {
        changeScene(event, "../views/browseView.fxml");

    }



}

