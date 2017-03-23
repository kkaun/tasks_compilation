package Lafore.ReverseStringStack;

/**
 * Created by Кира on 07.08.2016.
 */
public class StackX {

    private int maxSize;
    private char[] stackArray;
    private int top;

    //--------------------------------------------------------------
    public StackX(int max) // Конструктор
    {
        maxSize = max;
        stackArray = new char[maxSize];
        top = -1;
    }

    //--------------------------------------------------------------
    public void push(char j) // Размещение элемента на вершине стека
    {
        stackArray[++top] = j;
    }

    //--------------------------------------------------------------
    public char pop() // Извлечение элемента с вершины стека
    {
        return stackArray[top--];
    }

    //--------------------------------------------------------------
    public char peek() // Чтение элемента с вершины стека
    {
        return stackArray[top];
    }

    //--------------------------------------------------------------
    public boolean isEmpty() // True, если стек пуст
    {
        return (top == -1);
    }
}
