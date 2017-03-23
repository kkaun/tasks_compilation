package Lafore.Ord_Array;

/**
 * Created by Кира on 11.08.2016.
 */
public class HanoiTowers {

    static int nDisks = 3;
    public static void main(String[] args)
    {
        doTowers(nDisks, 'A', 'B', 'C');
    }
    //-----------------------------------------------------------

    //В аргументах doTowers() передается количество перемещаемых дисков, а также ис-
    //ходный (from), промежуточный (inter) и приемный (to) стержни. Количество дисков
    //уменьшается на единицу при каждом рекурсивном вызове.


    public static void doTowers(int topN,
                                char from, char inter, char to)
    {
        if(topN==1)
            System.out.println("Disk 1 from " + from + " to "+ to);
        else
        {
            doTowers(topN-1, from, to, inter); // from-->inter
            System.out.println("Disk " + topN +
                    " from " + from + " to "+ to);
            doTowers(topN-1, inter, from, to); // inter-->to
        }
    }
}
