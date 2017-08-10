package leetcode;

import java.util.function.BiConsumer;

/**
 */
public class L2017061201_125_Valid_Palindrome {
    public boolean isPalindrome(String s) {
        String lowerCase = s.toLowerCase();
        String noMarks = removeNonAplabeticCars(lowerCase);
        return isRealPalindrome(noMarks);
    }

    private boolean isRealPalindrome(String noMarks) {
        int half = noMarks.length()/2;
        for (int i = 0; i < half; i++) {
            if (noMarks.charAt(i) != noMarks.charAt(noMarks.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    private String removeNonAplabeticCars(String lowerCase) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < lowerCase.length(); i++) {
            if (Character.isLetterOrDigit(lowerCase.charAt(i))) {
                sb.append(lowerCase.charAt(i));
            }
        }
        return sb.toString();
    }
}