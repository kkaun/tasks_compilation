package com.javarush.test.level21.lesson05.task01;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* Equals and HashCode
В классе Solution исправить пару методов equals/hashCode в соответствии с правилами реализации этих методов.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, last);
    }

    @Override
    public boolean equals(Object n) {

        Solution object = (Solution) n;

        if (this == n)
            return true;
        if (n == null)
            return false;
        if (getClass() != n.getClass())
            return false;

        return Objects.equals(first, object.first) && Objects.equals(last, object.last);
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
