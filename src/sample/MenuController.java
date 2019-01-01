package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.Space.Space;

import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;

import static javafx.scene.paint.Color.*;


public class MenuController extends Thread{
    public Group shareGroup = new Group();

    @FXML protected void handleNewGame(ActionEvent event) throws InterruptedException {


        Space space = new Space();
        Stage gameStage = new Stage();
        shareGroup.getChildren().add(space.mainGroupBuilder());

        Scene scene = new Scene(shareGroup,1080,SharedData.gameHeight);
      //  run();
        space.moveCircleOnKeyPress(scene, space.circle);

        gameStage.setScene(scene);

        gameStage.setResizable(false);
        gameStage.show();
    }

//    @Override
//    public void run()
//    {
//        for (int i = 0; i < 10; i++) {
//            ImageView carV = new ImageView("sample/res/car1.png");
//            shareGroup.getChildren().add(carV);
//
//            System.out.println(i);
//            carV.setX(-50);
//            carV.setY(80);
////            for (int j = 0; j < 1080; j++) {
////                System.out.println(j);
//                carV.setTranslateX(100);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
////            }
//
//        }
//    }

    @FXML protected void handleSettings(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Settings/Settings.fxml"));
        Scene scene = new Scene(root,Color.BLACK);

//        Stage stage = new Stage();
//        stage = SharedData.theStage;
//        stage.setTitle("Settings");
//
//        stage.setResizable(false);

        SharedData.theStage.setTitle("Settings");
        SharedData.theStage.setScene(scene);
        SharedData.theStage.show();

    }

    @FXML protected void handleExit(ActionEvent event)
    {
        SharedData.theStage.close();
    }

}
