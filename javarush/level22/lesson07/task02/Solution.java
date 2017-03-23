package com.javarush.test.level22.lesson07.task02;

/* МНЕ нравится курс JavaRush
Исправить метод getFormattedString так, чтобы он возвращал строку с параметрами для форматирования.
Параметры должны меняться местами.
Должен быть вывод:
МНЕ нравится курс JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(String.format(getFormattedString(), "JavaRush", "курс", "мне", "нравится"));
        //должен быть вывод
        //"МНЕ нравится курс JavaRush"
    }
    public static String getFormattedString() {

        String s = "%3$S %4$s %2$s %1$s"; //%-для определения формата, 1$(2$,3$,4$..) - порядковый номер, осн. на кол-ве фор
                                            //матрируемых эл-тов, s - опр. фортматриуемого символа(строка)

        return s;

    }
}
