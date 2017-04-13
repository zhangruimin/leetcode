/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/#/description
 */
public class L2017041303_Find_the_Difference {
    public char findTheDifference(String s, String t) {
        char c = t.charAt(t.length() - 1);
        for (int i = 0; i < s.length(); i++) {
            c ^= s.charAt(i);
            c ^= t.charAt(i);
        }
        return c;
    }
    public char findTheDifference_mine(String s, String t) {
        int[] count = new int[26];
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            count[aChar - 'a']++;
        }

        char[] tChars = t.toCharArray();
        for (char tChar : tChars) {
            if (count[tChar - 'a'] == 0) {
                return tChar;
            }
            count[tChar - 'a'] --;
        }
        return 'a';
    }
}

