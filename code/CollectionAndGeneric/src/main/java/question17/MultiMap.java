package question17;

import java.util.*;

class MultiMap<K, V> {
    private Map<K, List<V>> map = new HashMap<>();

    public void put(K key, V value) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(value);
    }

    public List<V> get(K key) {
        return map.getOrDefault(key, Collections.emptyList());
    }

    public void printAll() {
        for (K key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }
    }
}
