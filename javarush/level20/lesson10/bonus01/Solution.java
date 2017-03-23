package com.javarush.test.level20.lesson10.bonus01;

import java.util.LinkedList;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {

    public static void main(String[] args) {

        long memoryStart = Runtime.getRuntime().freeMemory();
        Long startTime = System.currentTimeMillis();

        long n = 146511209;
        int[] numbers = getNumbers((int) n);

        System.out.println("Armstrong nums:");
        for (int i : numbers) {
            System.out.print(i + " ");
        }

        System.out.println();
        long estimatedTime = System.currentTimeMillis() - startTime;
        long memoryEnd = Runtime.getRuntime().freeMemory();
        long estimatedMemory = memoryStart - memoryEnd;
        System.out.println("Время подсчета: " + (double) estimatedTime / 1000 + " c");
        System.out.println("Использованная память: " + (double)estimatedMemory / 1024 / 1024 + " МБ");
    }

    public static int[] getNumbers(int N) {

        int pow = 10;
        LinkedList<Integer> list = new LinkedList<>();
        // initial powers for the number 0-9
        long[] powers = { 0l, 1l, 2l, 3l, 4l, 5l, 6l, 7l, 8l, 9l };

        for (long i = 1; i < N; i++) {   //проходимся по всем числам от 1 до N
            if (i == pow) {              //добавляем 0 к итерации каждый раз, когда достиграем очередного порога
                pow *= 10;
                // calculate i^length
                for (int pi = 1; pi < 10; pi++) {
                    powers[pi] *= pi;
                }
            }
            long s = i;
            long k = 0;

            while (s > 0) {
                int r = (int)(s % 10);    //остаток от деления на 10 одного из вероятных чисел Арсмтронга
                k += powers[r];           //увеличиваем k на во
                if (k > i)
                    break;
                s /= 10;
            }

            if (k == i)
                list.add((int) i);
        }

        int[] arr = new int[list.size()];

        for(int g = 0; g < list.size(); g++){
            arr[g] = list.get(g);
        }

        return arr;
    }

}
