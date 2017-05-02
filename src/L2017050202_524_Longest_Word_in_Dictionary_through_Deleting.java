import java.util.Arrays;
import java.util.List;

/**
 */
public class L2017050202_524_Longest_Word_in_Dictionary_through_Deleting {
    public static void main(String[] args) {
        new L2017050202_524_Longest_Word_in_Dictionary_through_Deleting().findLongestWord("aewfafwafjlwajflwajflwafj",
                Arrays.asList("ewaf", "awefawfwaf", "awef", "awefe", "ewafeffewafewf"));

    }
    public String findLongestWord(String s, List<String> d) {
        if (s.length() == 0 || d.isEmpty()) {
            return "";
        }

        String result = "";

        for (String word : d) {
            if (word.length() < result.length()) {
                continue;
            }
            boolean matched = matchWord(s, word);
            if (!matched) {
                continue ;
            }
            if (word.length() > result.length()) {
                result = word;
                continue ;
            }
            if (word.compareTo(result) < 0) {
                result = word;
            }
        }
        return result;
    }

    private boolean matchWord(String s, String word) {

        int j = 0;

        char[] chars = word.toCharArray();
        for (char aChar : chars) {
            while (j < s.length() && s.charAt(j) != aChar) {
                j++;
            }
            if (j == s.length()) {
                return false;
            }
            if (s.charAt(j) == aChar) {
                j++;
            }
        }
        return true;
    }

}





