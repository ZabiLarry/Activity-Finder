package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import sample.utils.AuthenticationSingleton;
import sample.utils.DatabaseConnection;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomePageController extends AbstractController implements Initializable {
    @FXML
    private Button indoorButton;
    @FXML
    private Button authenticationButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*BackgroundImage backgroundImage = new BackgroundImage( new Image( getClass().getResource("../resources/vollyball.jpg").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        if(AuthenticationSingleton.getInstance().getUser() != null){
            authenticationButton.setText("Log out");
            authenticationButton.setOnAction(event -> {
                try {
                    logOut(event);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            System.out.println(AuthenticationSingleton.getInstance().getUser().getEmail());
            System.out.println(AuthenticationSingleton.getInstance().getUser().getId());
        }else{
            authenticationButton.setText("Log in");
            authenticationButton.setOnAction(event -> {
                try {
                    logIn(event);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
        }


        BackgroundImage backgroundImage = new BackgroundImage( new Image( getClass().getResource("../resources/vollyball.jpg").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
>>>>>>> b561afc6ad0c361baf0c3bd6446eddfbba247739
        Background vollyBall = new Background(backgroundImage);
        indoorButton.setBackground(vollyBall);*/
    }

    @FXML
    private void toSettings(ActionEvent event) throws IOException {
        if(AuthenticationSingleton.getInstance().getUser() != null){
            Parent homeViewParent = FXMLLoader.load(getClass().getResource("../views/settingsView.fxml"));
            Scene homeScene = new Scene(homeViewParent);

            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(homeScene);
            window.show();

        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING,"Please log in first!");
            alert.show();
        }




    }

    @FXML
    private void toBrowse(ActionEvent event) throws IOException {

        try {
            DatabaseConnection db = new DatabaseConnection();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/browseView.fxml"));
            Parent root = (Parent) loader.load();
            BrowseController browseController = loader.getController();
            browseController.receiveFunction(db.browseController());
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

    @FXML
    private void logOut(ActionEvent event) throws IOException {

        AuthenticationSingleton.getInstance().setUser(null);
        authenticationButton.setText("Log in");
        authenticationButton.setOnAction(event2 -> {
            try {
                logIn(event2);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

    }

    @FXML
    private void logIn(ActionEvent event) throws IOException {
        changeScene(event, "../views/loginView.fxml");

    }

}
