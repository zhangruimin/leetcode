import java.util.ArrayList;
import java.util.List;

/**
 */
public class L2017042802_438_Find_All_Anagrams_in_a_String {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }

        int[] hash = new int[26];
        for (int i = 0; i < p.length(); i++) {
            hash[p.charAt(i) - 'a']++;
        }

        int count = p.length();
        int left = 0;
        int right = 0;

        while (right < s.length()) {
            int num = hash[s.charAt(right) - 'a'];
            if (num > 0) {
                count--;
            }
            hash[s.charAt(right) - 'a']--;

            right++;
            if (count == 0) {
                result.add(left);
            }

            if (right - left == p.length()) {
                if (hash[s.charAt(left) - 'a'] >= 0) {
                    count++;
                }
                hash[s.charAt(left) - 'a']++;
                left++;
            }
        }
        return result;
    }

    public List<Integer> findAnagrams_mine(String s, String p) {
        ArrayList<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }

        int[] counts = new int[26];

        for (int i = 0; i < p.length(); i++) {
            counts[p.charAt(i) - 'a']++;
        }

        for (int i = 0; i < p.length(); i++) {
            counts[s.charAt(i) - 'a']--;
        }

        if (allZeros(counts)) {
            result.add(0);
        }

        for (int end = p.length(); end < s.length(); end++) {
            counts[s.charAt(end - p.length()) - 'a']++;
            counts[s.charAt(end) - 'a']--;

            if (allZeros(counts)) {
                result.add(end - p.length() + 1);
            }

        }
        return result;
    }

    private boolean allZeros(int[] counts) {
        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}





