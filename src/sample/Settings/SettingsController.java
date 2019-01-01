package sample.Settings;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import sample.SharedData;
import java.io.IOException;


public class SettingsController {

    @FXML protected Slider roadSlider ;
    @FXML protected Slider crosswalkSlider ;
    @FXML protected Slider difficultySlider;

    public void initialize() //handle Sliders
    {
        try {
            roadSlider.valueProperty().addListener(new ChangeListener<Number>() {
                public void changed(ObservableValue<? extends Number> ov,
                                    Number old_val, Number new_val) {
                    int x = new_val.intValue();
                    SharedData.lineCount = x;
                    SharedData.gameHeight = (x) * SharedData.ROAD_HEIGHT + 80 + 120 + SharedData.TopMargin;          }
            });

            crosswalkSlider.valueProperty().addListener(new ChangeListener<Number>() {
                public void changed(ObservableValue<? extends Number> ov,
                                    Number old_val, Number new_val) {
                    SharedData.crosswalkXPosition = new_val.intValue();
                }
            });
        }
        catch (Exception e)
        {
            System.err.printf("error in initialize method: from SettingController.java.\nException:%s",e);
        }

    }

    @FXML
    protected void handleBack(ActionEvent event) throws IOException {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("../Menu.fxml"));
            Scene scene = new Scene(root, Color.BLACK);
            SharedData.theStage.getIcons().add(new Image("sample/Settings/icon.jpg"));
            SharedData.theStage.setScene(scene);
            SharedData.theStage.setTitle("Walk Over Highway");
        }
        catch (Exception e)
        {
            System.err.printf("error in handleBack: from SettingController.java.\nException:%s",e);
        }
    }


    @FXML protected CheckBox bridgeOption;
    @FXML
    protected  void handleBridgeOption(ActionEvent event)
    {
        try {
            SharedData.bridgeOption = bridgeOption.isSelected();
        }
        catch (Exception e)
        {
            System.err.printf("error in handleBridgeOption: from SettingController.java.\nException:%s",e);
        }

    }

}
