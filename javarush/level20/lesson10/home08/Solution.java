package com.javarush.test.level20.lesson10.home08;

/* Правильный вывод
Расставить обращение к методам суперкласса и модификаторы доступа так, чтобы вывод на экран был следующим:

C class, method2
A class, method2
A class, method1
B class, method1

1. Из одного метода можно вызвать только один метод суперкласса.
2. Из одного метода можно вызвать только один метод класса.
3. Можно менять модификаторы доступа к методам.
*/

//Если не обозначить method1 как приватный, то вместо «A class, method1» будет выдаваться «С class, method1»,
// поскольку в main() создана ссылка типа «А» на объект типа «С» [A a = new C();], что означает следующее —
// методы public переменной (ссылки) «а» будут ссылаться на методы объекта на которые она указывает, тобишь на «С».
// Применяя к методу модификатор доступа «private» — метод выполнится в том классе к которому принадлежит ссылка,
// а не объект. К примеру если к методу 2 в классе «А» применить модификатор «private»,
// то наша ссылка «а» у которой тип «А» — останется в своем методе класса «А»
// и выведет вместо первой строки «C class, method2» строку «А class, method2».


public class Solution {
    public static void main(String[] s) {
        A a = new C();
        a.method2();
    }

    public static class A {
        private void method1() {
            System.out.println("A class, method1");
        }

        public void method2() {
            System.out.println("A class, method2");
            method1();
        }
    }

    public static class B extends A {
        public void method1() {
            super.method2();
            System.out.println("B class, method1");
        }

        public void method2() {
            System.out.println("B class, method2");
        }
    }

    public static class C extends B {
        public void method1() {
            System.out.println("C class, method1");
        }

        public void method2() {
            System.out.println("C class, method2");
            super.method1();
        }
    }
}