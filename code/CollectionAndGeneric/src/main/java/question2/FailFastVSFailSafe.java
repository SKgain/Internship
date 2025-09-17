package question2;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;


public class FailFastVSFailSafe {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

            failFast(list);
            failSafe(list);


    }

    public static void failFast(List<String> list) {
        for (String s : list) {
            if (s.equals("d")) {
                list.remove(s);
            }
        }

        System.out.println(list);
        System.out.println(list.size());
    }

    public static void failSafe(List<String> list) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            if (s.equals("a")) {
                iterator.remove();
            }
        }
        System.out.println(list);
        System.out.println(list.size());
    }

}











