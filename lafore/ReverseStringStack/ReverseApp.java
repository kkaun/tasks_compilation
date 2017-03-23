package Lafore.ReverseStringStack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Кира on 07.08.2016.
 */
public class ReverseApp {

    public static void main(String[] args) throws IOException
    {
        String input, output;
        while(true)
        {
            System.out.print("Enter a string: ");
            System.out.flush();
            input = getString(); // Чтение строки с клавиатуры
            if( input.equals("") ) // Завершение, если [Enter]
                break;

            // Создание объекта Reverser
            Reverser theReverser = new Reverser(input);
            output = theReverser.doRev(); // Использование
            System.out.println("Reversed: " + output);
        }
    }
    //--------------------------------------------------------------
    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}
