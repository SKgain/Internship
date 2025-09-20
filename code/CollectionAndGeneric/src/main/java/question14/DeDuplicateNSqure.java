package question14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeDuplicateNSqure {
    public static <T> List<T> removeDuplicatesN2(List<T> list) {
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (!result.contains(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "apple", "cherry", "banana");
        List<String> deduped = removeDuplicatesN2(list);
        System.out.println(deduped);
    }
}
