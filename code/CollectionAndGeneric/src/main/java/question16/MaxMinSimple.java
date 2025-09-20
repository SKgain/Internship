package question16;

import java.util.*;

public class MaxMinSimple {

    public static <T> T max(List<T> list, Comparator<T> comp) {
        if (list.isEmpty()) return null;

        T max = list.get(0);
        for (T item : list) {
            if (comp.compare(item, max) > 0) {
                max = item;
            }
        }
        return max;
    }

    public static <T> T min(List<T> list, Comparator<T> comp) {
        if (list.isEmpty()) return null;

        T min = list.get(0);
        for (T item : list) {
            if (comp.compare(item, min) < 0) {
                min = item;
            }
        }
        return min;
    }

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 5, 20, 8, 15);

        System.out.println("Numbers: " + numbers);
        System.out.println("Max: " + max(numbers, (a, b) -> a - b));
        System.out.println("Min: " + min(numbers, (a, b) -> a - b));

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
        System.out.println("Names: " + names);
        System.out.println("Longest Name: " + max(names, (a, b) -> a.length() - b.length()));
        System.out.println("Shortest Name: " + min(names, (a, b) -> a.length() - b.length()));
    }
}
