package com.javarush.test.level27.lesson15.big01.statistic.event;

import java.util.Date;

/**
 * Created by Кира on 19.12.2016.
 */
public interface EventDataRow {

    EventType getType();

    Date getDate();
    int getTime();
}
