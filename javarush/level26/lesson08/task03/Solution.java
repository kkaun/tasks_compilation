package com.javarush.test.level26.lesson08.task03;

/* Распределение элементов по корзинам с собственным локом.
В синхронизированных блоках используйте нужный лок.
*/
public class Solution {

    public static void main(String[] args) {

        Object o1 = new Object();
        Object o2 = new Object();
        Object o3 = new Object();
        Object o4 = new Object();
        Object o5 = new Object();
        Object o6 = new Object();

        Solution solution = new Solution(10);
        for (int i = 0; i < 10; i++) {
            solution.buckets[i] = new Node(o1, o2);
            solution.buckets[i].next = new Node(o3, o4);
            solution.buckets[i].next.next = new Node(o5, o6);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(solution.hash(solution.buckets[i].key));
            System.out.println(solution.hash(solution.buckets[i].next.key));
            System.out.println(solution.hash(solution.buckets[i].next.next.key));
            System.out.println(1111);
        }

        System.out.println(solution.get(solution.buckets[0].key));
    }


    private static final int NUMBER_LOCKS = 12;
    private final Node[] buckets;
    private final Object[] locks;

    private static class Node {
        public Node next;
        public Object key;
        public Object value;

        public Node(Object o1, Object o2) {
            this.key = o1;
            this.value = o2;
        }
    }

    public Solution(int numberBuckets) {
        buckets = new Node[numberBuckets];
        locks = new Object[NUMBER_LOCKS];
        for (int i = 0; i < NUMBER_LOCKS; i++) {
            locks[i] = new Object();
        }
    }


    /**
     * final int hash(Object k) {
     int h = hashSeed;
     if (0 != h && k instanceof String) {
     return sun.misc.Hashing.stringHash32((String) k);
     }

     h ^= k.hashCode();

     // This function ensures that hashCodes that differ only by
     // constant multiples at each bit position have a bounded
     // number of collisions (approximately 8 at default load factor).
     h ^= (h >>> 20) ^ (h >>> 12);
     return h ^ (h >>> 7) ^ (h >>> 4);
     }
     * @param key
     * @return
     */

    private final int hash(Object key) {
        return Math.abs(key.hashCode() % buckets.length);
    }




    /**
     * public V get(Object key) {
     if (key == null)
     return getForNullKey();
     Entry<K,V> entry = getEntry(key);

     return null == entry ? null : entry.getValue();
     }
     */

    public Object get(Object key) {
        int hash = hash(key);
        synchronized (locks[hash%NUMBER_LOCKS]) {
            for (Node m = buckets[hash]; m != null; m = m.next) {
                if (m.key.equals(key)) return m.value;
            }
        }
        return null;
    }



    public void clear() {
        for (int i = 0; i < buckets.length; i++) {
            synchronized (locks[i%NUMBER_LOCKS]) {
                buckets[i] = null;
            }
        }
    }
}
