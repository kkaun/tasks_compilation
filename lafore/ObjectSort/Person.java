package Lafore.ObjectSort;

/**
 * Created by Кира on 05.08.2016.
 */
public class Person {

    private String lastName;
    private String firstName;
    private int age;
    //-----------------------------------------------------------
    public Person(String last, String first, int a)
    { // Конструктор
        lastName = last;
        firstName = first;
        age = a;
    }
    //-----------------------------------------------------------
    public void displayPerson()
    {
        System.out.print(" Last name: " + lastName);
        System.out.print(", First name: " + firstName);
        System.out.println(", Age: " + age);
    }
    //-----------------------------------------------------------
    public String getLast() // Получение фамилии
    {
        return lastName;
    }
}
