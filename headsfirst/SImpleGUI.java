package HeadsFirst;

import javax.swing.*;

/**
 * Created by Кира on 26.05.2016.
 */
public class SImpleGUI {

    public static void main(String[] args){

        JFrame frame = new JFrame();
        JButton button = new JButton("click me");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(button);

        frame.setSize(300, 300);

        frame.setVisible(true);

    }


}
