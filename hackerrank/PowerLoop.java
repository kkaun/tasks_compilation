import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Kir on 10.04.2017.
 */
public class PowerLoop {

        public static void main(String []argh){
            Scanner in = new Scanner(System.in);
            int t=in.nextInt();
            for(int i=0;i<t;i++){
                int a = in.nextInt();//5
                int b = in.nextInt();//3
                int n = in.nextInt();//5

                int prevSum = 0;
                int nextSum = 0;
                int oddCount = 1;

                for(int j = 0; j < n; j++) {

                    a = a + (int)Math.pow(2, j)*b;
                    System.out.print(a + " ");

                }

                System.out.println();


            }
            in.close();

        }

}
