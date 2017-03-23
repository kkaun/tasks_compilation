package Lafore.SortedList;

/**
 * Created by Кира on 09.08.2016.
 */
public class Link {

    public long dData; // Данные
    public Link next; // Ссылка на следующий элемент списка
    // -------------------------------------------------------------
    public Link(long dd) // Конструктор
    { dData = dd; }
    // -------------------------------------------------------------
    public void displayLink(){
        System.out.print(dData + " ");
    }
}
