import java.util.Arrays;

/**
 * Created by Kir on 11.04.2017.
 */
public class Anagram {

    static boolean isAnagram(String a, String b) {

        // Complete the function by writing your code here.
        String a1 = a.toLowerCase();
        String b1 = b.toLowerCase();

        char[] word1 = a1.toCharArray();
        char[] word2 = b1.toCharArray();

        Arrays.sort(word1);
        Arrays.sort(word2);
        return Arrays.equals(word1, word2);
    }

}
