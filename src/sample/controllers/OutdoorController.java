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

    DatabaseConnection dbconnect = new DatabaseConnection();
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    @FXML
    private void toHome(ActionEvent event) throws IOException {
        homePage(event);
    }
    @FXML
    private void toKajak(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/browseView.fxml"));
            Parent root = (Parent) loader.load();
            BrowseController browseController = loader.getController();
            browseController.recieveFunction(dbconnect.selectActivities("kayaking"));
            browseController.showText("kayaking");
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    @FXML
    private void toClimbing(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/browseView.fxml"));
            Parent root = (Parent) loader.load();
            BrowseController browseController = loader.getController();
            browseController.recieveFunction(dbconnect.selectActivities("climbing"));
            browseController.showText("climbing");
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    @FXML
    private void toSwimming(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/browseView.fxml"));
            Parent root = (Parent) loader.load();
            BrowseController browseController = loader.getController();
            browseController.recieveFunction(dbconnect.selectActivities("swimming"));
            browseController.showText("swimming");
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    @FXML
    private void toFishing(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/browseView.fxml"));
            Parent root = (Parent) loader.load();
            BrowseController browseController = loader.getController();
            browseController.recieveFunction(dbconnect.selectActivities("fishing"));
            browseController.showText("fishing");
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    @FXML
    private void toAdventure(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/browseView.fxml"));
            Parent root = (Parent) loader.load();
            BrowseController browseController = loader.getController();
            browseController.recieveFunction(dbconnect.selectActivities("zipline"));
            browseController.showText("zipline");
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
