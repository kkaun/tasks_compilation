package Lafore.LinkedList;

/**
 * Created by Кира on 09.08.2016.
 */
public class Link {

    public String iData; // Данные (ключ)
    public double dData; // Данные
    public Link next; // Следующий элемент в списке
    // -------------------------------------------------------------
    public Link(String id, double dd) // Конструктор
    {
        iData = id; // Инициализация данных
        dData = dd; // ('next' автоматически
    } // присваивается null)
    // -------------------------------------------------------------
    public void displayLink() // Вывод содержимого элемента
    {
        System.out.print("{" + iData + ", " + dData + "} ");
    }
} // Конец класса Link
////////////////////////////////////////////////////////////////


