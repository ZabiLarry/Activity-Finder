package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import sample.utils.DatabaseConnection;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomePageController extends AbstractController implements Initializable {
    @FXML
    private Button indoorButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BackgroundImage backgroundImage = new BackgroundImage( new Image( getClass().getResource("../resources/vollyball.jpg").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background vollyBall = new Background(backgroundImage);
        indoorButton.setBackground(vollyBall);
    }

    @FXML
    private void toSettings(ActionEvent event) throws IOException {
        Parent homeViewParent = FXMLLoader.load(getClass().getResource("views/settingsView.fxml"));
        Scene homeScene = new Scene(homeViewParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(homeScene);
        window.show();

        changeScene(event, "../views/loginView.fxml");
    }

    @FXML
    private void toBrowse(ActionEvent event) throws IOException {

        try {
            DatabaseConnection db = new DatabaseConnection();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/browseView.fxml"));
            Parent root = (Parent) loader.load();
            BrowseController browseController = loader.getController();
            browseController.recieveFunction(db.browseController());
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();


        }catch (IOException e){
            e.printStackTrace();
        }

    }


    @FXML
    private void toOutdoor(ActionEvent event) throws IOException {
        changeScene(event, "../views/outdoorView.fxml");

    }

    @FXML
    private void toIndoor(ActionEvent event) throws IOException {
        changeScene(event, "../views/indoorView.fxml");
    }


}
