import java.util.ArrayList;

/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/#/description
 */
public class L20170407_First_Unique_Character_in_a_String {
    public int firstUniqChar(String s) {
        int[] hash = new int[26];
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            hash[aChar - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (hash[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}

