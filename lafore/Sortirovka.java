package Lafore;

/**
 * Created by Кира on 23.03.2016.
 */
public class Sortirovka {

    public static void main(String[] args) {
    }

    public static void selectionSort(int array[]) {
    /*По очереди будем просматривать все подмножества
      элементов массива (0 - последний, 1-последний,
      2-последний,...)*/
        int array1[] = {1, 2, 3, 4, 5, 6, 7, 7, 5, 4};


        for (int i = 0; i < array1.length; i++) {
        /*Предполагаем, что первый элемент (в каждом
           подмножестве элементов) является минимальным */
            int min = array1[i];
            int min_i = i;
        /*В оставшейся части подмножества ищем элемент,
           который меньше предположенного минимума*/
            for (int j = i + 1; j < array1.length; j++) {
                //Если находим, запоминаем его индекс
                if (array[j] < min) {
                    min = array1[j];
                    min_i = j;
                }
            }


        }
    }
}
