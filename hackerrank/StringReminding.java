/**
 * Created by Kir on 10.04.2017.
 */
import java.io.*;
import java.util.*;

public class StringReminding {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        /* Enter your code here. Print output to STDOUT. */

        int al = A.length();
        int bl = B.length();

        int l = al + bl;

        System.out.println(l);

        int minLength = Math.min(al, bl);

        if(A.charAt(0) > B.charAt(0)){
            System.out.println("Yes");
        } else{
            System.out.println("No");
        }

        System.out.println(Character.toString(A.charAt(0)).toUpperCase()+A.substring(1) + " " +
                Character.toString(B.charAt(0)).toUpperCase()+B.substring(1));



    }
}