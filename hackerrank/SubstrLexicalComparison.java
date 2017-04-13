import java.util.*;

/**
 * Created by Kir on 10.04.2017.
 */
public class SubstrLexicalComparison {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        //SOLUTION 1
        Scanner sc = new Scanner(System.in);

        System.out.println("------------------SOLUTION 1");
        System.out.println();

        String str = "snizzlepizzle";
        int k = 3;

        SortedSet<String> set = new TreeSet<String>();

        for (int i = 0; i <= str.length() - k; i++) {
            set.add(str.substring(i, i + k));
        }

        System.out.println("-----" + set.size());

        for(String s : set){
            System.out.println(s);
        }


        System.out.println();
        System.out.println(set.first());
        System.out.println(set.last());

        sc.close();


        //SOLUTION 2,  BAD
        sc = new Scanner(System.in);

        System.out.println();
        System.out.println("------------------SOLUTION 2");
        System.out.println();

        str = "snizzlepizzle";
        k = 3;

        List<String> list = new ArrayList();

        for (int i = 0; i <= str.length() - k; i++) {
            list.add(str.substring(i, i + k));
        }

        System.out.println("-----" + list.size());

        Collections.sort(list);

        for(String s : list){
            System.out.println(s);
        }


        System.out.println();
        System.out.println(list.get(0));
        System.out.println(list.get(list.size()-1));

    }
}
