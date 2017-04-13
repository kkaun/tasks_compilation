import java.util.Scanner;

/**
 * Created by Kir on 12.04.2017.
 */
public class NegativeSubArraysCount {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int h = 0; h < n; h++){
            arr[h] = sc.nextInt();
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum < 0) {// If the most recent sum is -ve, count++
                    count++;
                }
            }
        }

        System.out.println(count);

    }
}
