package leetcode;

/**
 */
public class L2018022801_748_Shortest_Completing_Word {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        String licensePlate1 = licensePlate.toLowerCase();
        int[] plateCount = getCharCount(licensePlate1);

        String currentShortest = null;

        for (String word : words) {
            if (currentShortest != null && word.length() >= currentShortest.length()) {
                continue;
            }
            int[] wordCount = getCharCount(word);
            if (pass(plateCount, wordCount)) {
                currentShortest = word;
            }
        }
        return currentShortest;
    }

    private boolean pass(int[] plateCount, int[] wordCount) {
        for (int i = 0; i < plateCount.length; i++) {
            if (plateCount[i] > wordCount[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] getCharCount(String licensePlate1) {
        int[] count = new int[26];
        for (char c : licensePlate1.toCharArray()) {
            if (c - 'a' >= 0 && c - 'a' <= 25) {
                count[c - 'a']++;
            }
        }
        return count;
    }
}
