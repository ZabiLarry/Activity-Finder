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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.model.Activity;


import sample.*;
import sample.model.User;
import sample.utils.AuthenticationSingleton;
import sample.utils.DatabaseConnection;
import sample.utils.PdfFormatter;


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
    private  Button savePDF;

    @FXML
    public Button saveEventBtn;
    ObservableList<Activity> listForDisplay = FXCollections.observableArrayList();
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    private void indoorButt(ActionEvent event) {
        DatabaseConnection dbconnect = new DatabaseConnection();
        listForDisplay = dbconnect.sortByIndoor();
        displayTable.setItems(listForDisplay);
    }
    @FXML
    private void outdoorButt(ActionEvent event) {
        DatabaseConnection dbconnect = new DatabaseConnection();
        listForDisplay = dbconnect.sortByOutdoor();
        displayTable.setItems(listForDisplay);
    }


   @FXML
    private void bringFavorite(ActionEvent event) {
        DatabaseConnection dbconnect = new DatabaseConnection();
        listForDisplay = dbconnect.sortByRFavorite(AuthenticationSingleton.getInstance().getUser().getId());
        StringBuilder vel = new StringBuilder();
        int c = 1;
        for (Activity a: listForDisplay){
            vel.append("[" + c +"]");
            vel.append(a.toString());
            vel.append("\n\n");
            c++;
        }
        displayTable.setItems(listForDisplay);
        savePDF.setVisible(true);
        savePDF.setOnMouseClicked(event1 -> {
            PdfFormatter.openPDFRecipeSaver(event,vel.toString());
        });
    }

    @FXML
    private void addToFavorite(ActionEvent event) {
    }

    @FXML
    private void rateButt(ActionEvent event) {

    }

    @FXML
    private void toHome(ActionEvent event) throws IOException {
        homePage(event);
    }

    public void receiveFunction(ObservableList<Activity> list) {

        listForDisplay = list;
        activityDis.setCellValueFactory(new PropertyValueFactory<>("name"));
        locationDis.setCellValueFactory(new PropertyValueFactory<>("location"));
        contactDis.setCellValueFactory(new PropertyValueFactory<>("contact"));
        typeDis.setCellValueFactory(new PropertyValueFactory<>("type"));
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


    public void addFavorite(ActionEvent event) {

        if(displayTable.getSelectionModel().getSelectedCells().size()==0){
            System.out.println("No row selected");
            return;
        }
        TablePosition position = displayTable.getSelectionModel().getSelectedCells().get(0);
        int row = position.getRow();

        Activity activity = displayTable.getItems().get(row);
        TableColumn col = position.getTableColumn();
        String data = (String) col.getCellObservableValue(activity).getValue();

        System.out.println(data);


        if (AuthenticationSingleton.getInstance().getUser() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "loginRegular failed", ButtonType.OK);
            alert.showAndWait();
            System.out.println("no user");
        } else {

            AuthenticationSingleton.getInstance().getUser().getFavoritedActivities().add(activity);

            for (int x = 0; x < AuthenticationSingleton.getInstance().getUser().getFavoritedActivities().size(); x++) {


                System.out.println(AuthenticationSingleton.getInstance().getUser().getFavoritedActivities().get(x).getName());

                DatabaseConnection dbconnect = new DatabaseConnection();
                

                dbconnect.addFavorite(AuthenticationSingleton.getInstance().getUser().getId(),
                        AuthenticationSingleton.getInstance().getUser().getFavoritedActivities().get(x).getId());

            }


        }

    }


}




