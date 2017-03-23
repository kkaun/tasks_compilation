package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Locale;

/**
 * Created by Кира on 07.11.2016.
 */
public class CashMachine {

    public static final String RESOURCE_PATH = "com.javarush.test.level26.lesson15.big01.resources.";

    public static void main(String[] args) throws InterruptOperationException {
        try
        {
            Locale.setDefault(Locale.ENGLISH);
            Operation login = Operation.LOGIN;
            CommandExecutor.execute(login);
            Operation curop = null;
            while (curop != Operation.EXIT)
            {
                curop = ConsoleHelper.askOperation();
                CommandExecutor.execute(curop);
            }
        }
        catch (Exception e) {
            ConsoleHelper.writeMessage("Сбой операции! Возвращаем карту...");
            e.printStackTrace();
        }


    }

}
