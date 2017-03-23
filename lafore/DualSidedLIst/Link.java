package Lafore.DualSidedLIst;

/**
 * Created by Кира on 09.08.2016.
 */
public class Link {

    public long dData; // Данные
    public String iData;
    public Link next; // Следующий элемент в списке
    // -------------------------------------------------------------
    public Link(long d, String dd) // Конструктор
    {
        dData = d;
        iData = dd;
    }
    // -------------------------------------------------------------
    public void displayLink() // Вывод содержимого элемента
    {
        System.out.print(dData + iData + " ");
    }
// -------------------------------------------------------------
}
