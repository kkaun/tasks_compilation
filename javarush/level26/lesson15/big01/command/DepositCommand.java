package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by Кира on 08.11.2016.
 */
class DepositCommand implements Command {

    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "deposit_en");

    @Override
    public void execute() throws InterruptOperationException {
        String currencyCode = ConsoleHelper.askCurrencyCode();

        ConsoleHelper.writeMessage(res.getString("before"));

        String [] denominations = ConsoleHelper.getValidTwoDigits(currencyCode);

        int denomination = Integer.parseInt(denominations[0]);

        int count = Integer.parseInt(denominations[1]);

        if(denomination <= 0 || count <= 0){
            ConsoleHelper.writeMessage(res.getString("invalid.data"));
        }else {
            CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode).addAmount(denomination, count);

            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), denomination*count, currencyCode));
        }
    }
}
