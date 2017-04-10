/**
 * https://leetcode.com/problems/ransom-note/#/description
 */
public class L20170409_Ransom_Note {

    public boolean canConstruct(String ransomNote, String magazine) {

        int[] hash = new int[26];
        char[] chars = magazine.toCharArray();
        for (char aChar : chars) {
            hash[aChar - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (hash[c - 'a'] == 0) {
                return false;
            }
            hash[c - 'a']--;
        }
        return true;
    }
}

