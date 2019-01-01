package sample.Space;

import javafx.scene.image.Image;

public class Car {

    private Image carImage;
    private int linePosition;
    public double speed;


    public Car(int linePosition, double speed,Image carImage) {

        this.carImage = carImage;
        this.linePosition = linePosition;
        this.speed = speed;
    }


}
