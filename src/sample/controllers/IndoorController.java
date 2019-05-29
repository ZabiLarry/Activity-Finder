package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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

public class IndoorController extends AbstractController implements Initializable {
    @FXML
    private Button vollyball, boxing, badminton, thaiBoxing, climbing, juJitsu, basketball, boxercise, soccer, swimming, squash, paddleBall;

    DatabaseConnection dbconnect = new DatabaseConnection();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // size for the subsequent buttons
        BackgroundSize bs = new BackgroundSize(112, 70, false, false, true, false);


        BackgroundImage backgroundImage = new BackgroundImage(new Image(getClass().getResource("../resources/vollyball.jpg").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bs);
        vollyball.setBackground(new Background(backgroundImage));

        backgroundImage = new BackgroundImage(new Image(getClass().getResource("../resources/images.jpg").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bs);
        boxing.setBackground(new Background(backgroundImage));

        backgroundImage = new BackgroundImage(new Image(getClass().getResource("../resources/badminton-1120x388-e1498505007776.jpg").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bs);
        badminton.setBackground(new Background(backgroundImage));

        backgroundImage = new BackgroundImage(new Image(getClass().getResource("../resources/YTo2OntzOjI6ImlkIjtpOjE0MzgzNzE7czoxOiJ3IjtpOjEwMjA7czoxOiJoIjtpOjMyMDA7czoxOiJjIjtpOjA7czoxOiJzIjtpOjA7czoxOiJrIjtzOjQwOiJmMTY1NzkzMTNiMmY2OTRmZWEzYzMyMzQ1N2U1OTU0MzJhMDQ1ZDE4Ijt9.jpg").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bs);
        thaiBoxing.setBackground(new Background(backgroundImage));

        backgroundImage = new BackgroundImage(new Image(getClass().getResource("../resources/o4bcgtff7lkuic44pxu4.jpg").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bs);
        climbing.setBackground(new Background(backgroundImage));

        backgroundImage = new BackgroundImage(new Image(getClass().getResource("../resources/bs.jpg").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bs);
        juJitsu.setBackground(new Background(backgroundImage));

        backgroundImage = new BackgroundImage(new Image(getClass().getResource("../resources/Basketball-Tryouts.jpg").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bs);
        basketball.setBackground(new Background(backgroundImage));

        backgroundImage = new BackgroundImage(new Image(getClass().getResource("../resources/Boxercise-369x369.jpg").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bs);
        boxercise.setBackground(new Background(backgroundImage));

        backgroundImage = new BackgroundImage(new Image(getClass().getResource("../resources/soccer-ball-ss-img.jpg").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bs);
        soccer.setBackground(new Background(backgroundImage));

        //swimming
        backgroundImage = new BackgroundImage(new Image(getClass().getResource("../resources/images.jpg").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bs);
        swimming.setBackground(new Background(backgroundImage));

        backgroundImage = new BackgroundImage(new Image(getClass().getResource("../resources/123123124125r41243.jpg").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bs);
        squash.setBackground(new Background(backgroundImage));

        backgroundImage = new BackgroundImage(new Image(getClass().getResource("../resources/Paddles.jpg").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bs);
        paddleBall.setBackground(new Background(backgroundImage));


        //TODO etc etc change the resource (image) and the button you are applying the background to
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
        browseController.showText("badminton");
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void toVollyball(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/browseView.fxml"));
            Parent root = (Parent) loader.load();
            BrowseController browseController = loader.getController();
            browseController.recieveFunction(dbconnect.selectActivities("volleyball"));
            browseController.showText("volleyball");
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    @FXML
    private void toSoccer(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/browseView.fxml"));
            Parent root = (Parent) loader.load();
            BrowseController browseController = loader.getController();
            browseController.recieveFunction(dbconnect.selectActivities("soccer"));
            browseController.showText("soccer");
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    @FXML
    private void toBoxing(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/browseView.fxml"));
            Parent root = (Parent) loader.load();
            BrowseController browseController = loader.getController();
            browseController.recieveFunction(dbconnect.selectActivities("boxing"));
            browseController.showText("boxing");
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    @FXML
    private void toBoxercise(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/browseView.fxml"));
            Parent root = (Parent) loader.load();
            BrowseController browseController = loader.getController();
            browseController.recieveFunction(dbconnect.selectActivities("boxercise"));
            browseController.showText("boxercise");
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    @FXML
    private void toThaiBoxing(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/browseView.fxml"));
            Parent root = (Parent) loader.load();
            BrowseController browseController = loader.getController();
            browseController.recieveFunction(dbconnect.selectActivities("thaiBoxing"));
            browseController.showText("thaiBoxing");
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    @FXML
    private void toBasketball(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/browseView.fxml"));
            Parent root = (Parent) loader.load();
            BrowseController browseController = loader.getController();
            browseController.recieveFunction(dbconnect.selectActivities("basketball"));
            browseController.showText("basketball");
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    @FXML
    private void toJuJitsui(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/browseView.fxml"));
            Parent root = (Parent) loader.load();
            BrowseController browseController = loader.getController();
            browseController.recieveFunction(dbconnect.selectActivities("jujitsu"));
            browseController.showText("jujitsu");
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
    private void toPaddleball(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/browseView.fxml"));
            Parent root = (Parent) loader.load();
            BrowseController browseController = loader.getController();
            browseController.recieveFunction(dbconnect.selectActivities("paddle Ball"));
            browseController.showText("paddle Ball");
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
            browseController.recieveFunction(dbconnect.selectActivities("Swimming"));
            browseController.showText("Swimming");
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    @FXML
    private void toSquash(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/browseView.fxml"));
            Parent root = (Parent) loader.load();
            BrowseController browseController = loader.getController();
            browseController.recieveFunction(dbconnect.selectActivities("squash"));
            browseController.showText("squash");
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }

    }



}

