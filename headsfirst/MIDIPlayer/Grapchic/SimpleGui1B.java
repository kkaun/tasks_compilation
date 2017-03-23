package HeadsFirst.MIDIPlayer.Grapchic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Created by Кира on 01.08.2016.
 */
public class SimpleGui1B implements ActionListener{

    JButton button;

    //Получение событий ActionEvent кнопки//
    public static void main (String [] args){
        SimpleGui1B gui = new SimpleGui1B();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        button = new JButton("click me");

        button.addActionListener(this);

        frame.getContentPane().add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent event) {
        button.setText("I've been clicked!"); //ПОКА НЕ РАБОТАЕТ!!!//
    }

}
