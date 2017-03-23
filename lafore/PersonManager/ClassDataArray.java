package Lafore.PersonManager;

/**
 * Created by Кира on 04.08.2016.
 */
public class ClassDataArray {

    private Person[] array; // Ссылка на массив
    private int nElems; // Количество элементов данных

    public ClassDataArray(int max) // Конструктор
    {
        array = new Person[max]; // Создание массива
        nElems = 0; // Пока нет ни одного элемента
    }
    //--------------------------------------------------------------

    public Person find(String searchName)
    { // Поиск заданного значения
        int j;
        for(j=0; j<nElems; j++) // Для каждого элемента
            if( array[j].getLast().equals(searchName) ) // Значение найдено?
                break; // Выход из цикла
        if(j == nElems) // Достигнут последний элемент?
            return null; // Да, значение не найдено
        else
            return array[j]; // Нет, значение найдено
    } // end find()
    //-------------------------------------------------------------


// Включение записи в массив
    public void insert(String last, String first, int age)
    {
        array[nElems] = new Person(last, first, age);
        nElems++; // Увеличение размера
    }
    //--------------------------------------------------------------


    public boolean delete(String searchName) { // Удаление из массива
        int j;
        for (j = 0; j < nElems; j++) // Поиск удаляемого элемента
            if (array[j].getLast().equals(searchName))
                break;
        if (j == nElems) // Найти не удалось
            return false;
        else // Значение найдено
        {
            for (int k = j; k < nElems; k++) // Сдвиг последующих элементов
                array[k] = array[k + 1];
            nElems--; // Уменьшение размера
            return true;
        }
    }


    public void displayA() // Вывод содержимого массива
    {
        for(int j=0; j<nElems; j++) // Для каждого элемента
            array[j].displayPerson(); // Вывод
    }
}
