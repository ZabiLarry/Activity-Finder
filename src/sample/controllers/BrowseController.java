package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.BackInterface;

import javax.swing.text.html.ListView;
import java.io.IOException;

public class BrowseController implements BackInterface {

    @FXML
    ListView listAct;

    private void initialize(){

    }

    @FXML
    private void toHome(ActionEvent event) throws IOException {
        Parent homeViewParent = FXMLLoader.load(getClass().getResource("views/homePageView.fxml"));
        Scene homeScene = new Scene(homeViewParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(homeScene);
        window.show();
    }

}
