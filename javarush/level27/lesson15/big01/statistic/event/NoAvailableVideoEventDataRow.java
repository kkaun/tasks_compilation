package com.javarush.test.level27.lesson15.big01.statistic.event;

import java.util.Date;

/**
 * Created by Кира on 19.12.2016.
 */
public class NoAvailableVideoEventDataRow implements EventDataRow {

    private Date currentDate;
    private int totalDuration;

    public NoAvailableVideoEventDataRow(int totalDuration){
        this.totalDuration = totalDuration;

        currentDate = new Date();
    }

    @Override
    public EventType getType() {
        return EventType.NO_AVAILABLE_VIDEO;
    }

    @Override
    public Date getDate() {
        return currentDate;
    }

    @Override
    public int getTime() {
        return totalDuration;
    }
}
