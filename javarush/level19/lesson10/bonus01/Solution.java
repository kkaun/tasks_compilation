package com.javarush.test.level19.lesson10.bonus01;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
строка0                           ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка5                           ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = reader.readLine();
        String file2 = reader.readLine();

        List<String> list1 = readFile(file1);
        List<String> list2 = readFile(file2);

        reader.close();

        while (updateList(list1, list2)) {
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }

    private static boolean updateList(List<String> l1, List<String> l2) {
        if (l1.isEmpty() && l2.isEmpty())
            return false;

        if (!l2.isEmpty() && l1.isEmpty()) {
            lines.add(new LineItem(Type.ADDED, l2.get(0)));
            l2.remove(0);
        }

        if (!l1.isEmpty() && l2.isEmpty()) {
            lines.add(new LineItem(Type.REMOVED, l1.get(0)));
            l1.remove(0);
        }

        if (l1.size() == 1 && l2.size() > 1) {

            if (l1.get(0).equals(l2.get(1))) {
                lines.add(new LineItem(Type.ADDED, l2.get(0)));
                lines.add(new LineItem(Type.SAME, l1.get(0)));
                l1.remove(0);
                l2.remove(0);
                l2.remove(1);
            }
        }

        if (l2.size() == 1 && l1.size() > 1) {

            if (l2.get(0).equals(l1.get(1))) {
                lines.add(new LineItem(Type.REMOVED, l1.get(0)));
                lines.add(new LineItem(Type.SAME, l2.get(0)));
                l1.remove(0);
                l1.remove(0);
                l2.remove(0);
            }
        }

        if (!l1.isEmpty() && !l2.isEmpty())
            if (l1.get(0).equals(l2.get(0))) {
                lines.add(new LineItem(Type.SAME, l1.get(0)));
                l1.remove(0);
                l2.remove(0);
            } else if (l1.get(0).equals(l2.get(1))) {
                lines.add(new LineItem(Type.ADDED, l2.get(0)));
                l2.remove(0);
            } else if (l2.get(0).equals(l1.get(1))) {
                lines.add(new LineItem(Type.REMOVED, l1.get(0)));
                l1.remove(0);
            }

        return !(l1.isEmpty() && l2.isEmpty());
    }

    private static List<String> readFile(String st) throws IOException {
        List<String> list = new LinkedList<>();

        BufferedReader reader = new BufferedReader(new FileReader(st));

        while (reader.ready()){

            list.add(reader.readLine());

        }

        return list;
    }
}