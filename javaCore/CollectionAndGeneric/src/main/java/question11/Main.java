package question11;

public class Main {
    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(4);
        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");
        cache.put(4, "D");
        System.out.println(cache);
        cache.put(5, "E");
        System.out.println(cache);
        cache.put(6, "F");
        System.out.println(cache);

        System.out.println(cache.getOrDefault(1, null));
        System.out.println(cache.getOrDefault(2, null));
        System.out.println(cache.getOrDefault(3, null));

    }
}
