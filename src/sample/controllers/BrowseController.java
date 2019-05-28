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
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.model.Activity;


import sample.*;
import sample.model.User;
import sample.utils.DatabaseConnection;


import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;



public class BrowseController extends AbstractController implements Initializable {


    @FXML
    private TableView<Activity> displayTable;

    @FXML
    private TableColumn<Activity, String> activityDis;
    @FXML
    private TableColumn<Activity, String> locationDis;
    @FXML
    private TableColumn<Activity, String> contactDis;
    @FXML
    private TableColumn<Activity, String> typeDis;
    @FXML
    private TableColumn<Activity, Byte> indoorDis;
    @FXML
    private TableColumn<Activity, Byte> outdoorDis;

    ObservableList<Activity> listForDisplay = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void typeButt(ActionEvent event) {
        DatabaseConnection dbconnect = new DatabaseConnection();
        listForDisplay = dbconnect.sortByType();
        displayTable.setItems(listForDisplay);
    }
    @FXML
    private void ratingButt(ActionEvent event) {
        ObservableList<Activity> listForShuffle;
        DatabaseConnection dbconnect = new DatabaseConnection();
        listForShuffle = dbconnect.sortByRating();
        listForDisplay = shuffleList(listForShuffle);
        displayTable.setItems(listForDisplay);

    }
    @FXML
    private void favoriteButt(ActionEvent event) {
        DatabaseConnection dbconnect = new DatabaseConnection();
        listForDisplay = dbconnect.sortByRFavorite(1);
        displayTable.setItems(listForDisplay);

    }
    @FXML
    private void locationButt(ActionEvent event) {
        DatabaseConnection dbconnect = new DatabaseConnection();
        listForDisplay = dbconnect.sortByLocation();
        displayTable.setItems(listForDisplay);
    }

    @FXML
    private void toHome(ActionEvent event) throws IOException {
       homePage(event);
    }

    public void recieveFunction(ObservableList<Activity> list){

        listForDisplay = list;
        displayTable.setItems(null);
        activityDis.setCellValueFactory(new PropertyValueFactory<>("name"));
        locationDis.setCellValueFactory(new PropertyValueFactory<>("location"));
        contactDis.setCellValueFactory(new PropertyValueFactory<>("contact"));
        typeDis.setCellValueFactory(new PropertyValueFactory<>("type"));
        indoorDis.setCellValueFactory(new PropertyValueFactory<>("indoor"));
        outdoorDis.setCellValueFactory(new PropertyValueFactory<>("outdoor"));
        displayTable.setItems(listForDisplay);
    }
    public ObservableList<Activity> shuffleList(ObservableList<Activity> activityList) {

        ObservableList<Activity> list = FXCollections.observableArrayList();

        for (Activity i : activityList) {
            list.add(i);
        }
        Collections.shuffle(list);
        activityList = list;
      return activityList;
    }
}



