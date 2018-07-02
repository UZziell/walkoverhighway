import java.io.File;

public class SharedData {

    public static int lineCount = 4;
    public static int crosswalkXPosition = 397; //pool = 130




    public final static int ROAD_HEIGHT = 90;
    public final static int TopMargin = 60;


    public final static String ROOT_PATH = new File("").getAbsolutePath();

    public static int gameHeight = (lineCount) * SharedData.ROAD_HEIGHT + 80 + 120 + TopMargin;//80: grassheight+10, 120: margin, 60: bridge



}
