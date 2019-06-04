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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class OutdoorController extends AbstractController implements Initializable {

    DatabaseConnection dbconnect = new DatabaseConnection();

    @FXML
    private Button kajak, outClimbing, outSwimming, hiking, fishing, adventure, golf, paintball;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        BackgroundSize bs = new BackgroundSize(112, 70, false, false, true, false);


        BackgroundImage backgroundImage = new BackgroundImage(new Image(getClass().getResource("../resources/Scenic-River-Canoe.jpg").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bs);
        kajak.setBackground(new Background(backgroundImage));

        backgroundImage = new BackgroundImage(new Image(getClass().getResource("../resources/friends-climbing-boulder--buttermilk-boulders--bishop--california--usa-692733837-5afda7cd642dca00376c4b1a.jpg").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bs);
        outClimbing.setBackground(new Background(backgroundImage));

        backgroundImage = new BackgroundImage(new Image(getClass().getResource("../resources/kam-000560-sprung-in-den-badesee-fotograf-kurt-tropper.jpg").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bs);
        outSwimming.setBackground(new Background(backgroundImage));

        backgroundImage = new BackgroundImage(new Image(getClass().getResource("../resources/AC05-fishing-replace.jpg").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bs);
        fishing.setBackground(new Background(backgroundImage));

        backgroundImage = new BackgroundImage(new Image(getClass().getResource("../resources/bear-creek-zipline-04-660x348.jpg").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bs);
        adventure.setBackground(new Background(backgroundImage));

        backgroundImage = new BackgroundImage(new Image(getClass().getResource("../resources/golf.jpg").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bs);
        golf.setBackground(new Background(backgroundImage));

        backgroundImage = new BackgroundImage(new Image(getClass().getResource("../resources/paintball-fvg.jpg").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bs);
        paintball.setBackground(new Background(backgroundImage));

        backgroundImage = new BackgroundImage(new Image(getClass().getResource("../resources/hiking.jpg").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bs);
        hiking.setBackground(new Background(backgroundImage));

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
            browseController.receiveFunction(dbconnect.selectActivities("kayaking"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
            browseController.receiveFunction(dbconnect.selectActivities("climbing"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
            browseController.receiveFunction(dbconnect.selectActivities("swimming"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
            browseController.receiveFunction(dbconnect.selectActivities("fishing"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
            browseController.receiveFunction(dbconnect.selectActivities("zipline"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @FXML
    private void toGolf(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/browseView.fxml"));
            Parent root = (Parent) loader.load();
            BrowseController browseController = loader.getController();
            browseController.receiveFunction(dbconnect.selectActivities("golf"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @FXML
    private void toHiking(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/browseView.fxml"));
            Parent root = (Parent) loader.load();
            BrowseController browseController = loader.getController();
            browseController.receiveFunction(dbconnect.selectActivities("hiking"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @FXML
    private void toPaintball(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/browseView.fxml"));
            Parent root = (Parent) loader.load();
            BrowseController browseController = loader.getController();
            browseController.receiveFunction(dbconnect.selectActivities("zipline"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
