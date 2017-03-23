package Lafore.LinkQueue;

/**
 * Created by Кира on 09.08.2016.
 */
public class Link {

    public long dData; // Данные
    public Link next; // Следующий элемент в списке
    // -------------------------------------------------------------
    public Link(long d) // Конструктор
    { dData = d; }
    // -------------------------------------------------------------
    public void displayLink() // Вывод содержимого элемента
    { System.out.print(dData + " "); }
// -------------------------------------------------------------
}

