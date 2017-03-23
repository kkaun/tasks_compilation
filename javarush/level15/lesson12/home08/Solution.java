package com.javarush.test.level15.lesson12.home08;

/* Дебаг, дебаг, и еще раз дебаг
Программа выводит 0 9, а должна 6 9. Найди одну! ошибку и исправь.
Используй дебаг. Для этого поставь breakpoint-ы(Ctrl+F8), потом зайди в меню Run -> Debug.
F9 - выполнение кода до следующего breakpoint-а
F8 - переход к следующей строке кода
*/

public class Solution {
    public static void main(String[] args) {
        new B(6);
    }

    public static class A {
        private int f1 = 0;

        public A(int f1) {
            this.f1 = f1;
            initialize();
        }

        protected void initialize() {
            System.out.println(f1);
        }
    }

    //Конструктор класса B вызывает конструктор класса A
    //Конструктор класса A вызывает initialize() класса A
    //Конструктор класса B продолжает работу и
    //вызывает initialize() класса B.

    public static class B extends A {
        protected int f1 = 3;

        public B(int f1) {
            super(f1);
            this.f1 += f1;
            initialize();
        }

        protected void initialize() {
            System.out.println(f1);
        }
    }
}
