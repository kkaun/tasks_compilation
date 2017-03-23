package com.javarush.test.level22.lesson09.task01;



import java.io.*;
import java.util.*;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {

    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sourceFileName = reader.readLine();

        FileReader r = new FileReader(sourceFileName);

        Scanner sc = new Scanner(r);

        StringBuilder sb = new StringBuilder();

        while (sc.hasNext()) {
            sb.append(sc.next() + " ");
        }

        reader.close();
        r.close();
        sc.close();

        ArrayList<String> words = new ArrayList<>(Arrays.asList(sb.toString().split(" ")));

        System.out.println(words);

        ArrayList<String> uniqueWords = new ArrayList<>();

        for (int i = 0; i < words.size(); i++) {
            if (!uniqueWords.contains(words.get(i))) {
                uniqueWords.add(words.get(i));
            }
        }

        System.out.println(uniqueWords);

        for (int i = 0; i < uniqueWords.size(); i++) {

            String s = uniqueWords.get(i);
            String reversed = new StringBuffer(s).reverse().toString();

            if (uniqueWords.indexOf(reversed) != -1 & !s.equals("") & !s.equals(reversed)) {
                Pair pair = new Pair();
                pair.first = uniqueWords.get(i);
                pair.second = reversed.toString();
                result.add(pair);
                uniqueWords.set(i, "");
            }
        }
        for (Pair pair: result) System.out.println(pair);

    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
