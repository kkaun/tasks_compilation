package Lafore.BubbleSort;

/**
 * Created by Кира on 05.08.2016.
 */
public class ArrayBub {

    private long[] a; // Ссылка на массив a
    private int nElems; // Количество элементов данных
    //--------------------------------------------------------------
    public ArrayBub(int max) // Конструктор
    {
        a = new long[max]; // Создание массива
        nElems = 0; // Пока нет ни одного элемента
    }
    //--------------------------------------------------------------
    public void insert(long value) // Вставка элемента в массив
    {
        a[nElems] = value; // Собственно вставка
        nElems++; // Увеличение размера
    }
    //--------------------------------------------------------------
    public void display() // Вывод содержимого массива
    {
        for(int j=0; j<nElems; j++) // Для каждого элемента
            System.out.print(a[j] + " "); // Вывод
        System.out.println("");
    }
    //--------------------------------------------------------------
    public void bubbleSort()
    {
        int max, min;

        long temp = 0;

        for(max = nElems - 1; max > 1; max--) // Внешний цикл (обратный)
            for(min = 0; min < max; min++) // Внутренний цикл (прямой)
                if( a[min] > a[min+1] ) { // Порядок нарушен?
                    // Тогда поменять местами
                    temp = a[min];
                    a[min] = a[min + 1];
                    a[min + 1] = temp;
                }
    }

}
