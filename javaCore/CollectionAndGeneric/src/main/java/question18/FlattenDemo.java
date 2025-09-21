package question18;

import java.util.Arrays;
import java.util.List;

public class FlattenDemo {
    public static void main(String[] args) {
        List<List<Integer>> nested = Arrays.asList(
                Arrays.asList(1, 2, 33),
                Arrays.asList(4, 55),
                Arrays.asList(6, 7, 8, 99)
        );

        List<Integer> flat = nested.stream()
                .flatMap(n->n.stream())
                .toList();

        System.out.println("Flattened list: " + flat);
    }
}
