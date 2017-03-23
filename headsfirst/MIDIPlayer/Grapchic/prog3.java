package HeadsFirst.MIDIPlayer.Grapchic;

import javax.swing.*;
import java.awt.*;

public class prog3 {

    public static void main(String[] args) {

        myFrame okno = new myFrame();

    }
}

class myFrame extends JFrame
{
    myFrame() {
        myPanel pn = new myPanel();
        Container cont = getContentPane();
        cont.add(pn);
        setBounds(10, 10, 1200, 700);
        setVisible(true);
    }

}

class myPanel extends JPanel
{
    public void paintComponent(Graphics gr)
    {
        Image image = new ImageIcon("C:\\Users\\Кира\\Desktop\\NeurophFrameworkDiagram.jpg").getImage();
        gr.drawImage(image, 3 ,4 ,this);
    }
}