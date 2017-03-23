package Lafore.LinkedList;

/**
 * Created by Кира on 09.08.2016.
 */
public class LinkListApp {

    public static void main(String[] args) {
        LinkList theList = new LinkList(); // Создание нового списка

        theList.insertFirst("Hoodie", 2.99); // Вставка 4 элементов
        theList.insertFirst("Sweater", 4.99);
        theList.insertFirst("Pants", 6.99);
        theList.insertFirst("Shorts", 8.99);

        theList.displayList(); // Вывод содержимого списка

        Link f = theList.find("Shorts"); // Поиск элемента
        if (f != null)
            System.out.println("Found link with key " + f.iData);
        else
            System.out.println("Can’t find link");


        Link d = theList.delete("Pants"); // Удаление элемента
        if (d != null)
            System.out.println("Deleted link with key " + d.iData);
        else
            System.out.println("Can’t delete link");

        theList.displayList(); // Вывод содержимого списка
    }
}
