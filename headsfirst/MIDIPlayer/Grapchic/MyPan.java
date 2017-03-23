package HeadsFirst.MIDIPlayer.Grapchic;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Кира on 01.08.2016.
 */
public class MyPan extends JPanel {

    public static void main(String[] args) {

    }


    protected void paintComponent(Graphics g) {
        g.fillRect(0, 0, 300, 300);


        int red = (int) (Math.random() * 255);

        int green = (int) (Math.random() * 255);

        int blue = (int) (Math.random() * 255);

        Color randomColor = new Color(red, green, blue);
        g.setColor(randomColor);
        g.fillOval(70, 70, 100, 100);

    }
}
