package question13;

import java.util.List;

public class Swap {
    public static <T> void swap(List<? super T> list, int i, int j) {
        T temp = (T) list.get(i);
        list.set(i, (T) list.get(j));
        list.set(j, temp);
    }
}
