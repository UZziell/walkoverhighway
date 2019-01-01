package sample.Settings;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.SharedData;


public class Settings extends Application {

    @Override
    public void start(Stage stage) throws Exception{

        SharedData.theStage = stage;

        Parent root = FXMLLoader.load(getClass().getResource("Settings.fxml"));
        Scene scene = new Scene(root, Color.BLACK);
        stage.setTitle(" ");
       // stage.setResizable(false);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.show();

    }



    public static void main(String[] args) {
        launch(args);

    }

}
