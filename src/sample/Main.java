package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("views/homePageView.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();


        // to connect to databse initialize DatabseConnection object and then call methods to fetch data and close the
        // connection after last query/method was executed.
        DatabaseConnection db = new DatabaseConnection();


        // ...

        db.testQuery();

        //...

        db.closeConnection();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
