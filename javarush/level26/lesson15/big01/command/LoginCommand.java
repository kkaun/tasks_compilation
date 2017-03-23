package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.*;

/**
 * Created by Кира on 16.12.2016.
 */
public class LoginCommand implements Command {

    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login_en");

    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");

    private Enumeration<String> cardIds = validCreditCards.getKeys();

    private Map<String, String> userDataRetrieved = getCardKeys();

    public Map<String, String> getCardKeys() {

        Map<String, String> data = new LinkedHashMap<>();

        while (cardIds.hasMoreElements()) {
            String key = cardIds.nextElement();
            String value = validCreditCards.getString(key);
            data.put(key, value);
        }
        return data;
    }

    @Override
    public void execute() throws InterruptOperationException {

        String enteredCardNum;
        String enteredCardPin;

        boolean pass = false;

        while (pass == false){

            ConsoleHelper.writeMessage(res.getString("before"));
            ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
            enteredCardNum = ConsoleHelper.readString();
            enteredCardPin = ConsoleHelper.readString();

            if(enteredCardNum.length() == 12 && enteredCardPin.length() == 4) {

                int counter = userDataRetrieved.size();

                for(Map.Entry<String, String> entry : userDataRetrieved.entrySet()) {

                    if (enteredCardNum.equals(entry.getKey()) && enteredCardPin.equals(entry.getValue())) {
                        pass = true;
                        ConsoleHelper.writeMessage(String.format(res.getString("success.format"), enteredCardNum));
                    } else {
                        counter --;
                    }
                }
                if(counter == 0){
                    ConsoleHelper.writeMessage(res.getString("specify.data"));
                    ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                }
            }else {
                ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), enteredCardNum));
            }
        }
    }
}
