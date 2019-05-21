package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ActivityController extends AbstractController {

    @FXML
    TextField tfName, tfLoc, tfWeb;

    @FXML
    ChoiceBox<String> cbRec;

    @FXML
    CheckBox cbFav;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tfName.setText("");//to get from db
        tfLoc.setText("");//to get from db
        tfWeb.setText("");//to get from db

        if (true) {//to get from db for fav
            cbFav.setSelected(true);
        }

        if (true) {//to get from db for rate
            cbFav.setSelected(true);
        }
    }

    @FXML
    private void toHome(ActionEvent event) throws IOException {
      homePage(event);
    }

}
