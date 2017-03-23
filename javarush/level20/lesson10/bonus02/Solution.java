package com.javarush.test.level20.lesson10.bonus02;

/* Алгоритмы-прямоугольники
1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        byte[][] b = new byte[][]{
                {1, 0, 0, 0},
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 1}
        };

        byte[][] c = new byte[][]{
                {0, 0, 1, 0},
                {1, 0, 1, 0},
                {1, 0, 0, 0},
                {0, 0, 0, 1}
        };

        byte[][] d = new byte[][]{
                {0, 0, 1, 0},
                {1, 0, 1, 1},
                {1, 0, 0, 0},
                {0, 1, 0, 1}
        };


        int countA = getRectangleCount(a);
        int countB = getRectangleCount(b);
        int countC = getRectangleCount(c);
        int countD = getRectangleCount(d);
        System.out.println("count = " + countA + ". Должно быть 0");
        System.out.println("count = " + countB + ". Должно быть 2");
        System.out.println("count = " + countC + ". Должно быть 3");
        System.out.println("count = " + countD + ". Должно быть 5");
    }

    public static int getRectangleCount(byte[][] a) {
        byte[][] b = a.clone();
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i].clone();
        }

        int rectCount = 0;
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (b[i][j] == 1) {
                    rectCount++;
                    for (int k = i; k < b.length; k++) {
                        if (b[k][j] == 0)
                            break;
                        for (int l = j; l < b.length; l++) {
                            if (b[k][l] == 1)
                                b[k][l] = 0;
                            else
                                break;
                        }
                    }
                }
            }
            System.out.println();
        }
        return rectCount;
    }
}
