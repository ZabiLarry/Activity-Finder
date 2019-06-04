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


public class ActivityEditController extends AbstractController {

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
    
    public Activity selectedActivity = null;

    private ObservableList<Activity> list = FXCollections.observableArrayList();
    private byte i;
    private byte o;

    DatabaseConnection db = new DatabaseConnection();

    @FXML
    private void reload(){

        list = db.getOwnedActivities();
        fillTable();
    }

    @FXML
    private void addActivity() {
        ObservableList<Activity> addActivityList = FXCollections.observableArrayList();


        if (noBlanks()) {

            if (indoorCB.isPressed()){
                i = 1;
            }else {
                i = 0;
            }

            if (outdoorCB.isPressed()){
                o = 1;
            }else {
                o = 0;
            }

            db.addActivity(nameTF.getText(), locTF.getText(), contactTF.getText(), typeTF.getText(), i, o);
            int id = 0;
            String name;
            String location;
            String contact;
            String type;
            byte in;
            byte out;
            name = nameTF.getText();
            location = locTF.getText();
            contact = contactTF.getText();
            type = typeTF.getText();
            in = i;
            out = o;
            Activity activity = new Activity(id,name,location,contact,type,in,out);
            addActivityList.add(activity);
            list.add(activity);

        }else {
            System.out.println("blanks");
        }
        fillTable();
    }

    @FXML
    private void updateActivity() {

        if (noBlanks()) {
            TablePosition position = table.getSelectionModel().getSelectedCells().get(0);
            System.out.println(position.toString());

            System.out.println(position.getTableColumn());
            TableColumn col = position.getTableColumn();
            String data = (String) col.getCellObservableValue(0).getValue();
            System.out.println(data);

            int id = 0;
            String name;
            String location;
            String contact;
            String type;
            byte in;
            byte out;
            name = nameTF.getText();
            location = locTF.getText();
            contact = contactTF.getText();
            type = typeTF.getText();
            in = i;
            out = o;
            Activity newActivity = new Activity(id,name,location,contact,type,in,out);
            DatabaseConnection.updateActivity(selectedActivity.getId(), newActivity);
            //list.add(activity);
        }
        reload();
    }

    @FXML
    private void deleteActivity() {
        TablePosition position = table.getSelectionModel().getSelectedCells().get(0);
        System.out.println(position.toString());

        System.out.println(position.getTableColumn());
        TableColumn col = position.getTableColumn();
        String data = (String) col.getCellObservableValue(0).getValue();
        System.out.println(data);
        Activity activity = table.getItems().get(position.getRow());
        DatabaseConnection.deleteActivity(activity.getID());

        reload();

    }

    private boolean noBlanks() {

        if ((nameTF.getText().equals("") || locTF.getText().equals("") || contactTF.getText().equals("") || typeTF.getText().equals(""))) {
            System.out.println("blanks");
            return false;

        } else {
            System.out.println("no blanks");
            return true;
        }
    }

    public void fillTable() {
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
        list = db.getOwnedActivities();
        fillTable();
    }


    public void fillFields() {
        TablePosition position = table.getSelectionModel().getSelectedCells().get(0);

        System.out.println(position.getTableColumn());
        TableColumn col = position.getTableColumn();
        String data = (String) col.getCellObservableValue(0).getValue();
        System.out.println(data);
        selectedActivity = table.getItems().get(position.getRow());

        nameTF.setText(selectedActivity.getName());
        locTF.setText(selectedActivity.getLocation());
        contactTF.setText(selectedActivity.getContact());
        typeTF.setText(selectedActivity.getType());

        if (selectedActivity.getOutdoor() == 1)
            outdoorCB.setSelected(true);

        if (selectedActivity.getIndoor() == 1)
            indoorCB.setSelected(true);
    }
}
