package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 */
public class L2018022802_692_Top_K_Frequent_Words {
    public static void main(String[] args) {
        new L2018022802_692_Top_K_Frequent_Words().topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2);
    }
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordCount = getWordCount(words);
        PriorityQueue<String> queue = new PriorityQueue<>((o1, o2) -> {
            Integer c1 = wordCount.get(o1);
            Integer c2 = wordCount.get(o2);
            if (c1 != c2) {
                return c1 - c2;
            }
            return o2.compareTo(o1);
        });

        for (String s : wordCount.keySet()) {
            if (queue.size() == k + 1) {
                queue.poll();
            }
            queue.offer(s);
        }

        LinkedList<String> result = new LinkedList<>();

        if (queue.size() > k) {
            queue.poll();
        }
        while (!queue.isEmpty()) {
            result.add(0, queue.poll());
        }
        return result;
    }

    private Map<String, Integer> getWordCount(String[] words) {
        HashMap<String, Integer> result = new HashMap<>();

        for (String word : words) {
            Integer count = result.getOrDefault(word, 0);
            result.put(word, count + 1);
        }
        return result;
    }
}
