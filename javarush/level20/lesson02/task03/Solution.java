package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    public final Properties p = new Properties();

    public static void main(String[] args) throws IOException {
        new Solution().fillInPropertiesMap();
        System.out.println(properties);

    }


    public void fillInPropertiesMap() throws IOException {
        //implement this method - реализуйте этот метод

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = null;
        String fileName = null;
        try {
            fileName = reader.readLine();
            fis = new FileInputStream(fileName);
            load(fis);

        }catch (Exception e){
            e.printStackTrace();
        }
        finally { reader.close();
            try { fis.close();
            }catch (NullPointerException e){}}
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        for(Map.Entry<String, String> entry : properties.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            p.setProperty(key, value);
        }
        p.store(outputStream, null);
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        p.load(inputStream);

        Enumeration e = p.propertyNames();

        while (e.hasMoreElements())
        {
            String key = (String) e.nextElement();
            properties.put(key, p.getProperty(key));
        }
    }
}