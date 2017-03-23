package com.javarush.test.level33.lesson15.big01.strategies;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Кира on 03.12.2016.
 */
public class Entry implements Serializable {


    Long key;
    String value;
    Entry next;
    int hash;

    public Entry(int hash, Long key, String value, Entry next){

        this.key = key;
        this.hash = hash;
        this.value = value;
        this.next = next;
    }

    public Long getKey(){
        return key;
    }

    public String getValue(){

        return value;
    }

    public int hashCode(){
        return Objects.hashCode(getKey()) ^ Objects.hashCode(getValue());
    }

    public String toString(){
        return getKey() + "=" + getValue();
    }

}
