import java.util.Scanner;

/**
 * Created by Kir on 11.04.2017.
 */
public class StringTokens {

    String h;
    String[] arr = h.split("\\P{Alpha}+");

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        if(!scan.hasNext()){
            System.out.println(0);
            return;
        }
        String s = scan.nextLine();
        // Write your code here.

        if(s.length() > 0 && s.length() <= 400000){

            String[] arr = s.trim().split("[ .,?!'@_]+");

            System.out.println(arr.length);
            for(String g : arr){
                System.out.println(g);
            }
        }

        if(s.length() == 0){
            System.out.println(0);
        }

        scan.close();
    }

}
