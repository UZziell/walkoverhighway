package sample;

import java.io.File;
import javafx.stage.*;



public class SharedData {


    public static int lineCount=4; //default
    public final static int ROAD_HEIGHT = 90;
    public final static int TopMargin = 60;

    public static int gameHeight = (lineCount) * ROAD_HEIGHT + 80 + 120 + TopMargin;;//80: grassheight+10, 60: bridge

    public static int crosswalkXPosition = 400; //middle



    public final static String ROOT_PATH = new File("").getAbsolutePath();


    public static Stage theStage;
    public  static Stage spaceStage;

    public static boolean bridgeOption;

    public static final int two1=45+TopMargin-25;
    public static final int two2=235+TopMargin-25;

    public static final int four1=45+TopMargin-25;
    public static final int four2=135+TopMargin-25;
    public static final int four3=325+TopMargin-25;
    public static final int four4=415+TopMargin-25;

    public static final int six1=45+TopMargin-25;
    public static final int six2=135+TopMargin-25;
    public static final int six3=180+TopMargin-25;
    public static final int six4=425+TopMargin-25;
    public static final int six5=515+TopMargin-25;
    public static final int six6=605+TopMargin-25;




}
