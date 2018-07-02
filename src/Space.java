// Fig. 8.18: DrawPanel.java
// Program that uses class MyLine
// to draw random lines.
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Space extends JPanel
{

private static BufferedImage lineImage;
private static BufferedImage grassImage;
private static BufferedImage crosswalkImage;



    // constructor, creates a panel with random shapes
    public Space()
    {
        setBackground(Color.BLACK);
        try
        {
            init();
        }

        catch(IOException e)
        {
            System.err.printf("Exception in Space constructor, %s",e);
        }
    }

    public static void init() throws IOException
    {

       lineImage = ImageIO.read(new File(SharedData.ROOT_PATH + "\\src\\res\\roadh90y.jpg"));
       grassImage =ImageIO.read(new File(SharedData.ROOT_PATH + "\\src\\res\\grass.jpg"));
       crosswalkImage = ImageIO.read(new File(SharedData.ROOT_PATH + "\\src\\res\\crosswalk6pixel.jpg"));

    }
    // for each shape array, draw the individual shapes
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);


        int x=0;
        for(int i=0 ; i < SharedData.lineCount ; i++)
        {
            for(int j=0; j<1000 ; j+=lineImage.getWidth()) {
                if (i == SharedData.lineCount / 2)//draw grass
                {
                    for (int k = 0; k < 1080; k += grassImage.getWidth())
                        g.drawImage(grassImage, k, ((i * lineImage.getHeight()) + SharedData.TopMargin), this);//grass
                    x = grassImage.getHeight();
                }
                g.drawImage(lineImage, j, ((i * lineImage.getHeight()) + SharedData.TopMargin) + x, this);//draw road
            }
        }

        for(int i=0;i<SharedData.gameHeight - 10*crosswalkImage.getHeight() ; i+=crosswalkImage.getHeight())
            g.drawImage(crosswalkImage,SharedData.crosswalkXPosition,i+SharedData.TopMargin+2,this); //crosswalk
    }
}