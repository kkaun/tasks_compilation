package Lafore.PersonManager;

/**
 * Created by Кира on 04.08.2016.
 */
public class Person {

    private String lastName;
    private String firstName;
    private int age;

    public Person(String last, String first, int a){
        this.lastName = last;
        this.firstName = first;
        this.age = a;
    }

    public void displayPerson(){
        System.out.println("Name: " + firstName);
        System.out.println("Last name: " + lastName);
        System.out.println("Age: " + age);

    }

    public String getLast(){
        return lastName;

    }

}
