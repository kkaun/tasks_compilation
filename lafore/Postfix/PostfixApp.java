package Lafore.Postfix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Кира on 08.08.2016.
 */
public class PostfixApp {

    public static void main(String[] args) throws IOException
    {
        String input;
        int output;
        while(true)
        {
            System.out.print("Enter postfix: ");
            System.out.flush();
            input = getString(); // Ввод строки с клавиатуры
            if( input.equals("") ) // Завершение, если нажата клавиша
                break; // [Enter]
// Создание объекта для разбора выражения
            ParsePost aParser = new ParsePost(input);
            output = aParser.doParse(); // Обработка выражения
            System.out.println("Evaluates to " + output);
        }
    }
    //--------------------------------------------------------------
    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}
