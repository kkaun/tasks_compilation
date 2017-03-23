package Lafore.DualSidedLIst;

/**
 * Created by Кира on 09.08.2016.
 */
public class FirstLastApp {

    public static void main(String[] args)
    { // Создание нового списка
        FirstLastList theList = new FirstLastList();

        theList.insertFirst(22, "fsde"); // Вставка в начало списка
        theList.insertFirst(44, "dwa");
        theList.insertFirst(66, "dwaa");
        theList.insertLast(11, "daww"); // Вставка в конец списка
        theList.insertLast(33, "GGG");
        theList.insertLast(55, "dadadwaaaaaaa");

        theList.displayList(); // Вывод содержимого списка

        theList.deleteFirst(); // Удаление первых двух элементов

        theList.deleteFirst();

        theList.displayList(); // Повторный вывод
    }
}
