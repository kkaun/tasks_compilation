package com.javarush.test.level17.lesson10.home09;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = reader.readLine();
        String file2 = reader.readLine();

        try {
            Scanner scanner1 = new Scanner(new File(file1));


            while (scanner1.hasNextLine()) {

                allLines.add(scanner1.nextLine());
            }

            Scanner scanner2 = new Scanner(new File(file2));
            while (scanner2.hasNextLine()) {

                forRemoveLines.add(scanner2.nextLine());
            }
                reader.close();
                scanner1.close();
                scanner2.close();

                new Solution().joinData();    //Это вызов нестатистического метода с статистического.
            }
            catch (IOException e){

            }

            catch (NumberFormatException e) {


        }
    }

    public void joinData() throws CorruptedDataException {

        if(allLines.containsAll(forRemoveLines)){
            allLines.removeAll(forRemoveLines);
        } else
    {
        allLines.clear();
        throw new CorruptedDataException();
    }
    }
}
