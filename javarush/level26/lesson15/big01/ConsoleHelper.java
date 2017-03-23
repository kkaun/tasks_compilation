package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

/**
 * Created by Кира on 07.11.2016.
 */
public class ConsoleHelper {

    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");

    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }


    public static String readString() throws InterruptOperationException {

        String message = "";
        try {
            message = bufferedReader.readLine();
            if (message.equalsIgnoreCase("EXIT")) {
                writeMessage(res.getString("the.end"));
                throw new InterruptOperationException();
            }
        } catch (IOException ignored) {

        }
        return message;
    }

    public static Operation askOperation() throws InterruptOperationException {

        boolean correctInput = false;
        Operation chosenOperation = Operation.INFO;
        while (!correctInput) {

            writeMessage(res.getString("choose.operation") + ": ");
            writeMessage("1-" + res.getString("operation.INFO"));
            writeMessage("2-" + res.getString("operation.DEPOSIT"));
            writeMessage("3-" + res.getString("operation.WITHDRAW"));
            writeMessage("4-" + res.getString("operation.EXIT"));

            String input = readString();
            int choice;

            try {
                choice = Integer.valueOf(input.trim());
                if(choice == 0) {
                    throw new IllegalArgumentException();
                }else {
                    chosenOperation = Operation.getAllowableOperationByOrdinal(choice);
                    correctInput = true;
                }
            } catch (IllegalArgumentException e) {

            }
        }
        return chosenOperation;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        while (true) {
            writeMessage(res.getString("choose.currency.code"));
            String str = readString();
            if (str.length() != 3) {
                writeMessage(res.getString("invalid.data"));
                writeMessage(res.getString("choose.currency.code"));
            } else {
                return str.toUpperCase();
            }
        }
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        while (true) {
            writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));
            String userInput = readString();
            String[] strmas = userInput.split(" ");
            try {
                if (strmas.length == 2 && Integer.parseInt(strmas[0]) >= 0 && Integer.parseInt(strmas[1]) >= 0) {
                    return strmas;
                } else {
                    writeMessage(res.getString("invalid.data"));
                }
            }catch (NumberFormatException ex) {
                writeMessage(res.getString("invalid.data"));
            }
        }
    }


}
