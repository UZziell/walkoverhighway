package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Menu extends Application {

    @Override
        public void start(Stage stage) throws Exception{

            SharedData.theStage = stage;



            Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
            Scene scene = new Scene(root,Color.BLACK);
            stage.setTitle("Walk Over Highway");
            stage.setResizable(false);

            stage = SharedData.theStage;
            stage.setScene(scene);
            stage.getIcons().add(new Image("sample/res/mainIcon.jpg"));
            stage.show();

    }



    public static void main(String[] args) {
        launch(args);

    }


}
