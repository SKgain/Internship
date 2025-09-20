package question14;

import java.util.*;

public class DeDuplicateN {
    public static <T> List<T> removeDuplicatesN(List<T> list) {
        List<T> result = new ArrayList<>();
        Set<T> seen = new HashSet<>();
        for (T item : list) {
            if (seen.add(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "apple", "cherry", "banana");
        List<String> deduped = removeDuplicatesN(list);
        System.out.println(deduped);
    }
}
