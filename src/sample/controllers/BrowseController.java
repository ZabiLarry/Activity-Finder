package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.model.Activity;
import sample.utils.AuthenticationSingleton;
import sample.utils.DatabaseConnection;
import sample.utils.PdfFormatter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class BrowseController extends AbstractController implements Initializable {

    private String text;

    @FXML
    private Button savePDF;

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
    private TextField searchText;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void indoorButt(ActionEvent event) {
        DatabaseConnection dbconnect = new DatabaseConnection();
        listForDisplay = dbconnect.sortByIndoor();
        displayTable.setItems(listForDisplay);
        savePDF.setDisable(true);
    }

    @FXML
    private void outdoorButt(ActionEvent event) {
        DatabaseConnection dbconnect = new DatabaseConnection();
        listForDisplay = dbconnect.sortByOutdoor();
        displayTable.setItems(listForDisplay);
        savePDF.setDisable(true);
    }


    @FXML
    private void bringFavorite(ActionEvent event) {
        DatabaseConnection dbconnect = new DatabaseConnection();

        if(AuthenticationSingleton.getInstance().getUser()==null) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Log in first", ButtonType.OK);
            alert.showAndWait();
            return;
        }

        listForDisplay = dbconnect.sortByRFavorite(AuthenticationSingleton.getInstance().getUser().getId());
        StringBuilder vel = new StringBuilder();
        int c = 1;
        for (Activity a : listForDisplay) {
            vel.append("[" + c + "]");
            vel.append(a.toString());
            vel.append("\n\n");
            c++;
        }
        displayTable.setItems(listForDisplay);
        savePDF.setVisible(true);
        savePDF.setOnMouseClicked(event1 -> {
            PdfFormatter.openPDFRecipeSaver(event, vel.toString());
        });
    }

    @FXML
    private void rateButt(ActionEvent event) {

    }

    @FXML
    private void searchButt(ActionEvent event) {

        ObservableList<Activity> listForDisplayName;
        ObservableList<Activity> listForDisplayLocation;
        ObservableList<Activity> listForDisplayType;

        if (searchText.getText().isEmpty()) {
            System.out.println("Please do not press the button if there's no input");
        } else if (!searchText.getText().isEmpty()) {
            text = searchText.getText();
            DatabaseConnection db = new DatabaseConnection();
            listForDisplayName = db.searchFunctionName(text);
            listForDisplayLocation = db.searchFunctionLocation(text);
            listForDisplayType = db.searchFunctionType(text);
            listForDisplay = combinedList(listForDisplayName, listForDisplayLocation, listForDisplayType);
            if (!listForDisplay.isEmpty()) {
                displayTable.setItems(listForDisplay);
                searchText.setText(null);
            } else {
                displayTable.setItems(null);
                searchText.setText(null);
                System.out.println("Not found");
            }
        } else {
            System.out.println("What else?");
        }
    }

    @FXML
    private void toHome(ActionEvent event) throws IOException {
        homePage(event);
    }

    public ObservableList<Activity> combinedList(ObservableList<Activity> listOne, ObservableList<Activity> listTwo, ObservableList<Activity> listThree) {
        ObservableList<Activity> returnList = FXCollections.observableArrayList();
        returnList.addAll(listOne);
        returnList.addAll(listTwo);
        returnList.addAll(listThree);
        return returnList;
    }

    public void receiveFunction(ObservableList<Activity> list) {

        listForDisplay = list;
        activityDis.setCellValueFactory(new PropertyValueFactory<>("name"));
        locationDis.setCellValueFactory(new PropertyValueFactory<>("location"));
        contactDis.setCellValueFactory(new PropertyValueFactory<>("contact"));
        typeDis.setCellValueFactory(new PropertyValueFactory<>("type"));
        displayTable.setItems(listForDisplay);
    }

    public void addToFavorite() {
        if (displayTable.getSelectionModel().getSelectedCells().size() == 0) {
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

                dbconnect.addFavorite(AuthenticationSingleton.getInstance().getUser().getId(), AuthenticationSingleton.getInstance().getUser().getFavoritedActivities().get(x).getId());

            }


        }

    }

}




