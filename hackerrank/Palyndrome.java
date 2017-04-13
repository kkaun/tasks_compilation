import java.util.Scanner;

/**
 * Created by Kir on 11.04.2017.
 */
public class Palyndrome {


    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
    /* Enter your code here. Print output to STDOUT. */
        System.out.println( A.equals( new StringBuilder(A).reverse().toString())
                ? "Yes" : "No" );


    }

}
