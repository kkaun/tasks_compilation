package com.javarush.test.level26.lesson15.big01;

import java.util.IllegalFormatException;

/**
 * Created by Кира on 07.11.2016.
 */
public enum Operation {

    LOGIN,
    INFO,
    DEPOSIT,
    WITHDRAW,
    EXIT;

    public static Operation getAllowableOperationByOrdinal(Integer i) throws IllegalFormatException {

        if (i < 1 || i > 4) throw new IllegalArgumentException();
        return Operation.values()[i];
    }


}
