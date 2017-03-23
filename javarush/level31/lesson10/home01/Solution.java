package com.javarush.test.level31.lesson10.home01;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

/* Читаем конфиги
Реализовать метод getProperties, который должен считывать свойства из переданного файла fileName.
fileName может иметь любое расширение - как xml, так и любое другое, или вообще не иметь.
Нужно обеспечить корректное чтение свойств.
При возникновении ошибок должен возвращаться пустой объект.
Метод main не участвует в тестировании.
Подсказка: возможно, Вам понадобится File.separator.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("E:\\JavaRush\\JavaRushHomeWork\\src\\com\\javarush\\test\\level31\\lesson10\\home01\\properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("E:\\JavaRush\\JavaRushHomeWork\\src\\com\\javarush\\test\\level31\\lesson10\\home01\\properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("E:\\JavaRush\\JavaRushHomeWork\\src\\com\\javarush\\test\\level31\\lesson10\\home01\\nonExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) throws IOException {

        Properties properties = new Properties();
        try(FileInputStream fis = new FileInputStream(fileName);) {

            properties.loadFromXML(fis);
        }
        catch (InvalidPropertiesFormatException e) {
            try (FileReader reader = new FileReader(fileName);)
            {
                properties.load(reader);
            } catch (IOException e2) {/*NOP*/}

        } catch (IOException someException) {/*NOP*/}

        return properties;
    }
}
