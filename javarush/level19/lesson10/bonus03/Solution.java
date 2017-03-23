package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.*;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Scanner scanner = new Scanner(new FileReader(reader.readLine()));
        String content ="";
        while(scanner.hasNext()){
            content += scanner.next();
        }
        scanner.close();

        String tag = args[0];

        int length = tag.length()+1;

        int pos = 0;
        int index = 0;
        int flag = 0;
        int open = 0;

        while((pos = content.indexOf(tag, index)) != -1) //Ищем совпадения для тега в пределах строки-контента
        {                                                // и сохраняем их индексы в pos
            if(content.substring(pos-1, pos + length-1).equals("<"+tag)) { //если совпадения нашлись, то проверяем теги
                                                                            //на "<+тег"
                if(flag == 0) {
                    flag++;                //если совпадения на "<+тег" нашлись, то плюсуем флаг на 1 и
                    open = pos;            //двигаемся дальше по контенту, поднимая значение open на значение pos
                    index = pos+1;         //+ поднимаем переменную index
                }
                else {
                    flag++;               //в противном случае просто плюсуем флаг на 1 и индекс на pos+1
                    index=pos+1;
                }

            } else if(content.substring(pos-2,pos+length).equals("</"+tag+">") && flag > 0) { //проверяем совпадения на "</+тег+>"

                if(flag == 1) {                                     //значение флага должно отвечать парности открывающих и
                    flag--;                                         //закрывающих тегов, т.е. быть 1, когда оба очерендных тега найдеы
                    System.out.println(content.substring(open-1,pos+length));
                    index=open+1;
                } else {
                    index = pos+1;
                    flag--;
                }

            } else
                index = pos+1;
        }
    }

}
