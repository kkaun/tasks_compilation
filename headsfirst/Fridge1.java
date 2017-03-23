package HeadsFirst;

/**
 * Created by Кира on 23.03.2016.
 */
public class Fridge1 {
    public static void main(String[] args) {
        int x = 3;
        while (x > 0) {
            if (x > 2) {
                System.out.print("a");
                x = x - 1;
                System.out.print("-");
            }
            if (x == 2) {
                System.out.print("b c");
                x = x - 1;
                System.out.print("-");
            }
            if (x == 1) {
                System.out.println("d");
            }
            break;


        }
    }
}
