package com.javarush.test.level10.lesson04.task03;

/* Задача №3 на преобразование целых типов
Добавить одну операцию по преобразованию типа, чтобы получался ответ: b=0
float f = (float)128.50;
int i = (int)f;
int b = (int)(i + f);
*/

public class Solution
{
    public static void main(String[] args)
    {
        int i = 13;
        byte b = (byte)i;
        double a = (int) 13.345;
        System.out.println(a);
    }
}
//Потому что именно так работает явное приведение типов в джаве (а может и не только в джаве).
// Если выполняется неявное приведение, при котором ширина типа целевого значения больше, чем ширина исходного типа, то все пройдет нормально.
// Например, привести byte к int можно без проблем и никаких неожиданностей не будет. А вот когда мы пытаемся выполнить обратное приведение,
// то наш более широкий тип может просто не поместиться в более узкий целевой.
// При этом величина целевого типа будет равна результату деления по модулю исходного значения на диапазон целевого типа.
// Поэтому, например, если взять число int = 500; и привести его к byte, то результат будет -12. Почитайте в интернете про
// неявное приведение примитивных типов более подробно, информации предостаточно.