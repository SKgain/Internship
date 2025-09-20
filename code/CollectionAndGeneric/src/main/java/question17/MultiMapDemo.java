package question17;

public class MultiMapDemo {
    public static void main(String[] args) {
        MultiMap<String, String> multiMap = new MultiMap<>();

        multiMap.put("fruit", "apple");
        multiMap.put("fruit", "banana");
        multiMap.put("fruit", "cherry");
        multiMap.put("vegetable", "carrot");
        multiMap.put("vegetable", "spinach");

        System.out.println("MultiMap contents:");
        multiMap.printAll();

        System.out.println("\nValues for 'fruit': " + multiMap.get("fruit"));
    }
}
