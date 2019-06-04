package sample.controllers;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import sample.model.Activity;
import sample.utils.DatabaseConnection;

import javax.mail.FetchProfile;
import javax.xml.crypto.Data;
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

    private ObservableList<Activity> list = FXCollections.observableArrayList();
    private byte i;
    private byte o;

    DatabaseConnection db = new DatabaseConnection();

    @FXML
    private void reload(ActionEvent event){

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
            addActivityList.add(new Activity(id,name,location,contact,type,in,out));

        }else {
            System.out.println("blanks");
        }
        fillTable();
    }

    @FXML
    private void updateActivity() {

        if (noBlanks()) {
            TablePosition position = table.getSelectionModel().getSelectedCells().get(0);
            int row = position.getRow();
            Activity activity = table.getItems().get(row);
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
            DatabaseConnection.updateActivity(newActivity, activity.getID());
            //list.add(activity);
        }
        fillTable();
    }

    @FXML
    private void deleteActivity() {

        ObservableList<Activity> deleteActivityList;
        //TablePosition position = table.getSelectionModel().getSelectedCells().get(0);
        System.out.println(table.getSelectionModel().getSelectedCells().get(0).toString());
        System.out.println(table.getItems().get(0));
        System.out.println(table.getItems().get(1));
        String name = table.getItems().get(0).nameProperty();
        String type = table.getItems().get(1).typeProperty();
        DatabaseConnection.deleteActivity(DatabaseConnection.getActivityID(name, type));
        deleteActivityList = db.getOwnedActivities();

        fillTable();
        //fillTable(deleteActivityList);
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
        System.out.println(position.toString());

        System.out.println(position.getTableColumn());
        TableColumn col = position.getTableColumn();
        //String data = (String) col.getCellObservableValue(activity).getValue();
        //System.out.println(data);
        String name = table.getItems().get(0).nameProperty();
        String type = table.getItems().get(1).typeProperty();
        int activityid = DatabaseConnection.getActivityID(name, type);
        nameTF.setText(DatabaseConnection.selectActivity(activityid).getName());
        locTF.setText(DatabaseConnection.selectActivity(activityid).getLocation());
        contactTF.setText(DatabaseConnection.selectActivity(activityid).getContact());
        typeTF.setText(DatabaseConnection.selectActivity(activityid).getType());

       /* if (activity.getOutdoor() == 1)
            outdoorCB.setSelected(true);

        if (activity.getIndoor() == 1)
            indoorCB.setSelected(true);*/
    }
}
