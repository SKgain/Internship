package question15;

import java.util.*;

public class TopKFrequent {
    public static List<String> topKFrequent(List<String> words, int k) {

        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }


        List<Map.Entry<String, Integer>> entries = new ArrayList<>(freqMap.entrySet());
        entries.sort((a, b) -> b.getValue() - a.getValue()); // descending


        List<String> topK = new ArrayList<>();
        for (int i = 0; i < k && i < entries.size(); i++) {
            topK.add(entries.get(i).getKey());
        }

        return topK;
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList(
                "apple", "banana", "apple", "cherry", "banana", "apple", "date"
        );
        int k = 3;

        List<String> topWords = topKFrequent(words, k);
        System.out.println("Top " + k + " frequent words: " + topWords);
    }
}
