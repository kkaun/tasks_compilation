package com.javarush.test.level33.lesson15.big01.tests;

import com.javarush.test.level33.lesson15.big01.Shortener;
import com.javarush.test.level33.lesson15.big01.strategies.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Кира on 04.12.2016.
 */
public class FunctionalTest {

    public void testStorage(Shortener shortener){

        String one = "hhhhhhhhhhhhhhhhhhhshshshshshshshshshs";
        String two = "dawdadawdwadwa";
        String three = "hhhhhhhhhhhhhhhhhhhshshshshshshshshshs";

        Long oneId = shortener.getId(one);
        Long twoId = shortener.getId(two);
        Long threeId = shortener.getId(three);

        Assert.assertNotEquals(twoId, oneId, 0);
        Assert.assertNotEquals(twoId, threeId, 0);
        Assert.assertEquals(oneId, threeId);

        String oneVal = shortener.getString(oneId);
        String twoVal = shortener.getString(twoId);
        String threeVal = shortener.getString(threeId);

        Assert.assertEquals(one, oneVal);
        Assert.assertEquals(two, twoVal);
        Assert.assertEquals(three, threeVal);

    }

    @Test
    public void testHashMapStorageStrategy(){

        Shortener shortener = new Shortener(new HashMapStorageStrategy());

        testStorage(shortener);
    }


    @Test
    public void testOurHashMapStorageStrategy(){

        Shortener shortener = new Shortener(new OurHashMapStorageStrategy());

        testStorage(shortener);
    }

    @Test
    public void testFileStorageStrategy(){

        Shortener shortener = new Shortener(new FileStorageStrategy());

        testStorage(shortener);
    }

    @Test
    public void testHashBiMapStorageStrategy(){

        Shortener shortener = new Shortener(new HashBiMapStorageStrategy());

        testStorage(shortener);
    }

    @Test
    public void testDualHashBidiMapStorageStrategy(){

        Shortener shortener = new Shortener(new DualHashBidiMapStorageStrategy());

        testStorage(shortener);
    }

    @Test
    public void testOurHashBiMapStorageStrategy(){

        Shortener shortener = new Shortener(new OurHashBiMapStorageStrategy());

        testStorage(shortener);
    }

}
