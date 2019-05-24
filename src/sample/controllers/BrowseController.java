package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import sample.model.Activity;


import sample.*;
import sample.utils.DatabaseConnection;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class BrowseController extends AbstractController implements Initializable {


    @FXML
    private ListView<String> listAct;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }


    @FXML
    private void toHome(ActionEvent event) throws IOException {
       homePage(event);
    }

    public void recieveFunction(ArrayList<String> activitiesList){

        ObservableList<String> checkList = FXCollections.observableList(activitiesList);

        for(int i=0;i<activitiesList.size();i++)
        {
            listAct.setItems(checkList);
        }

    }



}
