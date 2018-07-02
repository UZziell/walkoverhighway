import javax.swing.JFrame;
import java.applet.Applet;
import java.io.IOException;
import java.util.Scanner;

;
class Test {

    public static void main(String[] args)
    {
        Space panel = new Space();

        JFrame jf = new JFrame();


        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(panel);

        jf.setSize(1080, SharedData.gameHeight);
        jf.setVisible(true);

    }
}
