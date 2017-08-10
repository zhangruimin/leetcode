package leetcode;

/**
 */
public class L2017041603_318_Maximum_Product_of_Word_Lengths {
    public int maxProduct(String[] words) {
        int max = 0;
        for (int i = 0; i < words.length - 1; i++) {
            boolean[] cache = turnToCache(words[i]);
            for (int j = i + 1; j < words.length; j++) {
                if (hasNoCommon(cache, words[j])) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }

    private boolean hasNoCommon(boolean[] cache, String word) {
        char[] chars = word.toCharArray();
        for (char aChar : chars) {
            if (cache[aChar - 'a']) {
                return false;
            }
        }
        return true;
    }

    private boolean[] turnToCache(String word) {
        boolean[] result = new boolean[26];
        char[] chars = word.toCharArray();
        for (char aChar : chars) {
            result[aChar-'a'] = true;
        }
        return result;
    }

}

