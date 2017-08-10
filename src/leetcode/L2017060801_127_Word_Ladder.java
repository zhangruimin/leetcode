package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 */
public class L2017060801_127_Word_Ladder {
    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        new L2017060801_127_Word_Ladder().ladderLength("hit", "cog", new ArrayList<>(wordList));
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();

        int distance = 2;
        queue.add(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                for (Iterator<String> iterator = wordList.iterator(); iterator.hasNext(); ) {
                    String s = iterator.next();

                    if (canConvert(current, s)) {
                        if (s.equals(endWord)) {
                            return distance;
                        }
                        queue.add(s);
                        iterator.remove();
                    }
                }
            }
            distance++;
        }
        return 0;
    }

    private boolean canConvert(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }
}