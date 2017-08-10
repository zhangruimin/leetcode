package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class L2017061202_131_Palindrome_Partitioning {
    public List<List<String>> partition(String s) {
        ArrayList<String> currentPartition = new ArrayList<>();
        ArrayList<List<String>> result = new ArrayList<>();
        backTrack(s, 0, currentPartition, result);

        return result;
    }

    private void backTrack(String s, int start, ArrayList<String> currentPartition, ArrayList<List<String>> result) {
        if (start >= s.length()) {
            result.add(new ArrayList<>(currentPartition));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String substring = s.substring(start, i + 1);
            if (isPalindrome(substring)) {
                currentPartition.add(substring);
                backTrack(s, i + 1, currentPartition, result);
                currentPartition.remove(currentPartition.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String substring) {
        int start = 0;
        int end = substring.length() - 1;

        while (start < end) {
            if (substring.charAt(start) != substring.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}