package sample.Space;

import javafx.animation.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.SharedData;

import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

public class Space{

    //loading images
    private Image roadImage = new Image("sample/res/road901080y.jpg");
    private Image grassImage = new Image("sample/res/grass1080.jpg");
    private Image crosswalkImage = new Image("sample/res/crosswalk6pixel.jpg");

    private Pane rootPane = new Pane();

    public Group mainGroupBuilder() throws InterruptedException {

        double x = 0;
        for (int i = 0; i < SharedData.lineCount; i++) {
            for (int j = 0; j < 1080; j += roadImage.getWidth()) {
                if (i == SharedData.lineCount / 2)//draw grass
                {
                    for (int k = 0; k < 1080; k += grassImage.getWidth()) {
                        // g.drawImage(grassImage, k, ((i * roadImage.getHeight()) + SharedData.TopMargin), this);//grass
                        ImageView grassView = new ImageView(grassImage);
                        grassView.setX(k);
                        grassView.setY(((i * roadImage.getHeight()) + SharedData.TopMargin));
                        rootPane.getChildren().add(grassView);

                        x = grassImage.getHeight();
                    }
                }
                //    g.drawImage(roadImage, j, ((i * roadImage.getHeight()) + SharedData.TopMargin) + x, this);//draw road
                ImageView roadView = new ImageView(roadImage);
                roadView.setX(j);
                roadView.setY(((i * roadImage.getHeight())) + x + SharedData.TopMargin);
                rootPane.getChildren().add(roadView);
            }
        }

        for (int i = 0; i < SharedData.gameHeight - 10 * crosswalkImage.getHeight(); i += crosswalkImage.getHeight()) {
            ImageView crosswalkView = new ImageView(crosswalkImage);
            crosswalkView.setX(SharedData.crosswalkXPosition);
            crosswalkView.setY(i + 2 + SharedData.TopMargin);
            rootPane.getChildren().add(crosswalkView);
        }

        if(SharedData.bridgeOption)
        {
            ImageView bridgeView = new ImageView("sample/res/bridge.png");
            bridgeView.setFitHeight(SharedData.gameHeight-120);
            bridgeView.setX(900);
            bridgeView.setY(SharedData.TopMargin-20);
            bridgeView.toFront();

            rootPane.getChildren().add(bridgeView);
        }


        Group spaceGroup = new Group();

        rootPane.getChildren().add(spaceGroup);


        Group carViews = new Group();
        ImageView[] carArray = new ImageView[46];

        for (int i = 1; i < 37; i++) {

            SecureRandom randomN = new SecureRandom();
            int randomnumber = (randomN.nextInt(1000));
            Image carImage = new Image("sample/res/car/car" + i + ".png");
            ImageView carView = new ImageView(carImage);

            carArray[i]=carView;
            carView.setFitHeight(50);
            carView.setFitWidth(100);

            // carView.setX(50-randomN.nextInt(5000));

            if (SharedData.lineCount == 2) {
                if(randomnumber%2==0){
                    carView.setY(SharedData.two1);
                }else
                {
                    carView.setY(SharedData.two2);
                }

            }

            if (SharedData.lineCount == 4) {

                if (randomnumber % 4 == 0) {
                    carView.setY(SharedData.four1);
                } else if (randomnumber % 4 == 1) {
                    carView.setY(SharedData.four2);
                } else if (randomnumber% 4 == 2) {
                    carView.setY(SharedData.four3);
                } else if (randomnumber % 4 == 3) {
                    carView.setY(SharedData.four4);
                }
            }

            if (SharedData.lineCount == 6) {

                if (randomnumber % 6 == 0) {
                    carView.setY(SharedData.six1);
                } else if (randomnumber % 6 == 1) {
                    carView.setY(SharedData.six2);
                } else if (randomnumber % 6 == 2) {
                    carView.setY(SharedData.six3);
                } else if (randomnumber % 6 == 3) {
                    carView.setY(SharedData.six4);
                } else if (randomnumber % 6 == 3) {
                    carView.setY(SharedData.six5);
                } else if (randomnumber % 6 == 5) {
                    carView.setY(SharedData.six6);
                }
            }
            carViews.getChildren().add(carView);
        }

        spaceGroup.getChildren().addAll(carViews);



        SecureRandom randNum = new SecureRandom();
        Timeline timeline = new Timeline();
        for (Node car : carViews.getChildren()) {
            timeline.getKeyFrames().addAll(
                    new KeyFrame(Duration.seconds(0), // set start position at 0
                            new KeyValue(car.translateXProperty(), -randNum.nextInt(50000))),
//                    new KeyFrame(Duration.seconds(50), // set end position at 40s
//                            new KeyValue(car.translateXProperty(), 5000)),
//                    new KeyFrame(Duration.seconds(100), // set start position at 0
//                            new KeyValue(car.translateXProperty(), -randNum.nextInt(50000))),
                    new KeyFrame(Duration.seconds(50), // set end position at 40s
                            new KeyValue(car.translateXProperty(), 5000)));

//            System.out.println(System.currentTimeMillis());

        }

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();




        //user
        Image image = new Image("sample/res/dude6550.png");
        circle.setFill(new ImagePattern(image));
        final Group group = new Group(circle);
        final TranslateTransition transition = createTranslateTransition(circle);

     //   rootNode.getChildren().add(group);
      //  moveCircleOnKeyPress(scene, circle);

        Group group1 = new Group(rootPane,spaceGroup,group);//rootPane: board, spaceGroup: cars, group:circle

        return group1;

        }
    public final Circle circle = createCircle();

    private static final int      KEYBOARD_MOVEMENT_DELTA = 20;
    private static final Duration TRANSLATE_DURATION      = Duration.seconds(0.001);

    private Circle createCircle() {
        final Circle circle = new Circle(SharedData.crosswalkXPosition+50, SharedData.lineCount*90+SharedData.TopMargin+100, 30, Color.BLUEVIOLET);
        circle.setOpacity(0.7);
        return circle;
    }

    private TranslateTransition createTranslateTransition(final Circle circle) {
        final TranslateTransition transition = new TranslateTransition(TRANSLATE_DURATION, circle);
        transition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent t) {
                circle.setCenterX(circle.getTranslateX() + circle.getCenterX());
                circle.setCenterY(circle.getTranslateY() + circle.getCenterY());
                circle.setTranslateX(0);
                circle.setTranslateY(0);
            }
        });
        return transition;
    }

    public void moveCircleOnKeyPress(Scene scene, final Circle circle) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:    circle.setCenterY(circle.getCenterY() - KEYBOARD_MOVEMENT_DELTA); break;
                    case RIGHT: circle.setCenterX(circle.getCenterX() + KEYBOARD_MOVEMENT_DELTA); break;
                    case DOWN:  circle.setCenterY(circle.getCenterY() + KEYBOARD_MOVEMENT_DELTA); break;
                    case LEFT:  circle.setCenterX(circle.getCenterX() - KEYBOARD_MOVEMENT_DELTA); break;
                }
            }
        });
    }



    }




