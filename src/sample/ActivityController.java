package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;

public class ActivityController implements BackInterface{

    @FXML
    TextField tfName, tfLoc, tfWeb;

    @FXML
    ChoiceBox<String> cbRec;

    @FXML
    CheckBox cbFav;

    private void initialize(){
        tfName.setText("");//to get from db
        tfLoc.setText("");//to get from db
        tfWeb.setText("");//to get from db

        if (true) {//to get from db
            cbFav.setSelected(false);
        }

        switch (cbRec.getValue().toString()){//to ger from db
            case "1":
                cbRec.setValue("1");
                break;
            case "2":
                cbRec.setValue("2");
                break;
            case "3":
                cbRec.setValue("3");
                break;
            case "4":
                cbRec.setValue("4");
                break;
            case "5":
                cbRec.setValue("5");
                break;
        }

    }



    @FXML
    private void toHome(ActionEvent event) throws IOException {
        Parent homeViewParent = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene homeScene = new Scene(homeViewParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(homeScene);
        window.show();
    }

}
