package HeadsFirst;

/**
 * Created by Кира on 23.03.2016.
 */
public class PoolPuzzle1 {
    public static void main(String[] args) {
        int x = 0;

        while (x < 1) {
            System.out.print("a ");
            x += 1;
            if (x < 2) {
                System.out.println("noise");
            }
            x += 2;
            if (x < 4) {
                System.out.println("annoys");
                x -= 2;
            }
            if (x > 0) {
                System.out.print("an");
            }
            System.out.print(" ");
            System.out.print("oyster");

        }
    }
}
