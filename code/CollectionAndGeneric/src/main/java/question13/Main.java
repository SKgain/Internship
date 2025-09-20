package question13;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Pair<Integer, String>> pairs = new ArrayList<>();
        pairs.add(new Pair<>(1, "Apple"));
        pairs.add(new Pair<>(2, "Banana"));

        System.out.println("Before swap: " + pairs);

        Swap.swap(pairs, 0, 1);
        System.out.println("After swap : " + pairs);
    }
}
