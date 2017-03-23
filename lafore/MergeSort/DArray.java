package Lafore.MergeSort;

/**
 * Created by Кира on 12.08.2016.
 */
public class DArray {

    private long[] theArray; // Ссылка на массив theArray
    private int nElems; // Количество элементов данных
    //-----------------------------------------------------------
    public DArray(int max) // Конструктор
    {
        theArray = new long[max]; // Создание массива
        nElems = 0;
    }

    //-----------------------------------------------------------



    public void insert(long value) // Занесение элемента в массив
    {
        theArray[nElems] = value; // Вставка элемента
        nElems++; // Увеличение размера
    }
    //-----------------------------------------------------------



    public void display() // Вывод содержимого массива
    {
        for(int j=0; j<nElems; j++) // Для каждого элемента
            System.out.print(theArray[j] + " "); // Вывод
        System.out.println("");
    }
    //-----------------------------------------------------------



    public void mergeSort() // Вызывается из main()
    { // Рабочая область
        long[] workSpace = new long[nElems];
        recMergeSort(workSpace, 0, nElems-1);
    }
//-----------------------------------------------------------



    private void recMergeSort(long[] workSpace, int lowerBound,
                              int upperBound)
    {
        if(lowerBound == upperBound) // Если только один элемент,
            return; // сортировка не требуется.
        else
        {
            // Поиск середины
            int mid = (lowerBound+upperBound) / 2;
// Сортировка нижней половины
            recMergeSort(workSpace, lowerBound, mid);
// Сортировка верхней половины
            recMergeSort(workSpace, mid+1, upperBound);
// Слияние
            merge(workSpace, lowerBound, mid+1, upperBound);
        }
    }
    //-----------------------------------------------------------



    private void merge(long[] workSpace, int lowPart,
                       int highPart, int upperBound)
    {
        int j = 0; // Индекс в рабочей области

        int lowerBound = lowPart;

        int mid = highPart-1;

        int n = upperBound-lowerBound+1; // Количество элементов

        while(lowPart <= mid && highPart <= upperBound)
            if( theArray[lowPart] < theArray[highPart] )
                workSpace[j++] = theArray[lowPart++];
            else
        workSpace[j++] = theArray[highPart++];

        while(lowPart <= mid)
            workSpace[j++] = theArray[lowPart++];

        while(highPart <= upperBound)
            workSpace[j++] = theArray[highPart++];

        for(j=0; j<n; j++)
            theArray[lowerBound+j] = workSpace[j];
    }
}
