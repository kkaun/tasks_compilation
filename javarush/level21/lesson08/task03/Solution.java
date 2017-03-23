package com.javarush.test.level21.lesson08.task03;

/* Запретить клонирование
Разрешите клонировать класс А
Запретите клонировать класс B
Разрешите клонировать класс C
Метод main не участвует в тестировании.
*/
public class Solution {

    public static void main(String[] args){

        A a = new A(3, 5);
        B b = new B(4, 6, "des");
        C c = new C(2, 5, "grdg");

        A cloneA = null;
        try {
            cloneA = a.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        B cloneB = null;
        try {
            cloneB = b.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        C cloneC = null;
        try {
            cloneC = c.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(a);
        System.out.println(cloneA);
        System.out.println(b);
        System.out.println(cloneB);
        System.out.println(c);
        System.out.println(cloneC);

    }
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        protected A clone() throws CloneNotSupportedException {
            A clone = new A(i, j);

            clone.i = this.i;
            clone.j = this.j;

            return clone;
        }
    }

    public static class B {
        private String name;
        private int i;
        private int j;

        public B(int i, int j, String name) {
            this.i = i;
            this.j = j;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        protected B clone() throws CloneNotSupportedException {
            throw  new CloneNotSupportedException();
        }
    }

    public static class C extends A {

        private String name;

        public C(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }


        @Override
        protected C clone() throws CloneNotSupportedException {

            C clone = new C(super.getI(), super.getJ(), name != null ? getName() : null);

            return clone;
        }
    }
}
