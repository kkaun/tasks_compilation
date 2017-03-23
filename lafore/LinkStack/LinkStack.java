package Lafore.LinkStack;

/**
 * Created by Кира on 09.08.2016.
 */
public class LinkStack {

    private LinkList theList;
    //--------------------------------------------------------------
    public LinkStack() // Конструктор
    {
        theList = new LinkList();
    }
    //--------------------------------------------------------------
    public void push(long j) // Размещение элемента на вершине стека
    {
        theList.insertFirst(j);
    }
    //--------------------------------------------------------------

    public long pop() // Извлечение элемента с вершины стека
    {
        return theList.deleteFirst();
    }
    //--------------------------------------------------------------
    public boolean isEmpty() // true, если стек пуст
    {
        return ( theList.isEmpty() );
    }
    //--------------------------------------------------------------
    public void displayStack()
    {
        System.out.print("Stack (top-->bottom): ");
        theList.displayList();
    }
//--------------------------------------------------------------
}

