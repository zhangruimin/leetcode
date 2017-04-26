/**
 * Interesting. come back
 */
public class L2017042603_424_Longest_Repeating_Character_Replacement {
    public int characterReplacement(String s, int k) {

        char[] chars = s.toCharArray();
        int[] counts = new int[26];

        int start = 0;
        int maxLength = 0;
        int maxCount = 0;

        for (int end = 0; end < s.length(); end++) {
            int charIndex = chars[end] - 'A';
            counts[charIndex]++;
            maxCount = Math.max(maxCount, counts[charIndex]);
            if (end - start + 1 - maxCount > k) {
                counts[chars[start] - 'A']--;
                start++;
            }
            maxLength = Math.max(end - start + 1, maxLength);
        }
        return maxLength;
    }

}





