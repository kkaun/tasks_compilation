package com.javarush.test.level16.lesson13.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. нить 1 должна бесконечно выполняться;
1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
Подсказка: Нить 4 можно проверить методом isAlive()
*/

public class Solution {


    public static List<Thread> threads = new ArrayList<Thread>(5);

    static{
        threads.add(new Eternity());
        threads.add(new Interrupted());
        threads.add(new Yra());
        threads.add(new Messag());
        threads.add(new Read());


    }

    public static void main(String[] args) {



    }

    public static class Eternity extends Thread implements Runnable {


        @Override
        public void run() {

            while (!isInterrupted()){

            }

        }
    }

    public static class Interrupted extends Thread implements Runnable {


        @Override
        public void run() {


            try{
                while(true){
                    sleep(500);
                }
            }
            catch(InterruptedException e){
                System.out.println("InterruptedException");
            }

        }
    }

    public static class Yra extends Thread implements Runnable {

        @Override
        public void run() {


            while (true)
            {
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }

            }
        }
    }

    public static class Messag extends Thread implements Runnable, Message {


        @Override
        public void showWarning() {

            interrupt();
            try {
                join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {

            while(!isInterrupted()){

            }

        }
    }

    public static class Read extends Thread implements Runnable {

        @Override
        public void run() {

            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String buffer = reader.readLine();
                int sum = 0;
                while (!buffer.equals("N"))
                {
                    sum=sum+Integer.parseInt(buffer);
                    buffer=reader.readLine();
                }
                System.out.println(sum);
            }
            catch (IOException e) {
            }

        }
    }
}

