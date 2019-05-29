package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.model.Activity;
import sample.utils.DatabaseConnection;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ActivityEditController extends AbstractController{

    @FXML

    TextField nameTF, locTF, contactTF, typeTF;

    @FXML
    CheckBox indoorCB;

    @FXML
    CheckBox outdoorCB;

    @FXML
    TableView<Activity> table;

    @FXML
    TableColumn<Activity, String> nameDis;

    @FXML
    TableColumn<Activity, String> typeDis;

    ObservableList<Activity> list = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        fillTable();
    }

    @FXML
    private void addActivity() {

        if (noBlanks())
            DatabaseConnection.addActivity(nameTF.getText(), locTF.getText(), contactTF.getText(), typeTF.getText(), indoorCB.isPressed(), outdoorCB.isPressed());
    }

    @FXML
    private void updateActivity() {

        if (noBlanks()) {
            table.setRowFactory(tv -> {
                TableRow<Activity> row = new TableRow<>();
                row.setOnMouseClicked(event -> {
                    if (event.getClickCount() == 2 && (!row.isEmpty())) {
                        Activity rowData = row.getItem();
                        DatabaseConnection.updateActivity(rowData.getID());
                    }
                });
                return row;
            });
        }

    }

    @FXML
    private void deleteActivity() {


    }

    private boolean noBlanks() {

        if (!(nameTF.getText().equals("") && locTF.getText().equals("") && contactTF.getText().equals("") && typeTF.getText().equals(""))) {
            return false;
        } else {
            return true;
        }
    }

    private void fillUp(Activity activity) {

        nameTF.setText(activity.getName());
        locTF.setText(activity.getLocation());
        contactTF.setText(activity.getContact());
        typeTF.setText(activity.getType());
        if (activity.getOutdoor() == 1)
            outdoorCB.setSelected(true);

        if (activity.getIndoor() == 1)
            indoorCB.setSelected(true);

    }

    public void fillTable(){

        table.setItems(null);
        nameDis.setCellValueFactory(new PropertyValueFactory<>("name"));
        typeDis.setCellValueFactory(new PropertyValueFactory<>("type"));
        table.setItems(list);
    }

    @FXML
    private void toHome(ActionEvent event) throws IOException {
        homePage(event);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }



}
