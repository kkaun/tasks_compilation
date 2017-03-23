package Lafore.DoubleSidedLinkedList;

/**
 * Created by Кира on 10.08.2016.
 */
public class Link {

    public long dData; // Данные
    public Link next; // Следующий элемент в списке
    public Link previous; // Предыдущий элемент в списке
    // -------------------------------------------------------------
    public Link(long d) // Конструктор
    { dData = d; }
    // -------------------------------------------------------------
    public void displayLink() // Вывод содержимого элемента
    { System.out.print(dData + " "); }
}
