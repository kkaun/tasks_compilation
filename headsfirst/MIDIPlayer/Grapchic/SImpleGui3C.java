package HeadsFirst.MIDIPlayer.Grapchic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Кира on 02.08.2016.
 */
public class SImpleGui3C implements ActionListener {

    JFrame frame;

    public static void main (String [] args) {
        SImpleGui3C gui = new SImpleGui3C();
        gui.go();
    }

    public void go(){

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Change Colors");
        button.addActionListener(this);

        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.setSize(500, 500);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent event) {

        frame.repaint();
    }
}
