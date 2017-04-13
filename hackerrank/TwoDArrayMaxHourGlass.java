import java.util.Scanner;

/**
 * Created by Kir on 12.04.2017.
 */
public class TwoDArrayMaxHourGlass {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int a[][] = new int[6][6];
        int maxSum = Integer.MIN_VALUE;

        for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
                a[i][j] = in.nextInt();
                if(i > 1 && j > 1){
                    int sum =
                            a[i][j]
                            + a[i][j-1]
                            + a[i][j-2]
                            + a[i-1][j-1]
                            + a[i-2][j]
                            + a[i-2][j-1]
                            + a[i-2][j-2];
                    if(sum > maxSum){
                        maxSum = sum;
                    }
                }
            }
        }
        System.out.println(maxSum);
    }
}
