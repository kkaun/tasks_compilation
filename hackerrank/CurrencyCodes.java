/**
 * Created by Kir on 10.04.2017.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class CurrencyCodes {


        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            double payment = scanner.nextDouble();
            scanner.close();

            // Write your code here.

            NumberFormat localPayment;

            localPayment = NumberFormat.getCurrencyInstance(Locale.US);
            System.out.println("US: " + localPayment.format(payment));

            localPayment = NumberFormat.getCurrencyInstance(new Locale("en", "in"));
            System.out.println("India: " + localPayment.format(payment));

            localPayment = NumberFormat.getCurrencyInstance(Locale.CHINA);
            System.out.println("China: " + localPayment.format(payment));

            localPayment = NumberFormat.getCurrencyInstance(Locale.FRANCE);
            System.out.println("France: " + localPayment.format(payment));

    }
}
