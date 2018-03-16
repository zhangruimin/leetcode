package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class L2018031601_763_Partition_Labels {
    public static void main(String[] args) {
        System.out.println(new L2018031601_763_Partition_Labels().partitionLabels("ababcbacadefegdehijhklij"));
    }
    public List<Integer> partitionLabels(String S) {
        ArrayList<Integer> result = new ArrayList<>();

        int[] lastAppear = new int[26];
        for (int i = 0; i < S.length(); i++) {
            lastAppear[S.charAt(i) - 'a'] = i;
        }
        int currentStart = 0;
        int currentLast = 0;
        for (int i = 0; i < S.length(); i++) {
            int charIndex = S.charAt(i) - 'a';

            if (lastAppear[charIndex] > currentLast) {
                currentLast = lastAppear[charIndex];
            }

            if (i == currentLast) {
                result.add(currentLast - currentStart + 1);
                currentStart = i + 1;
                currentLast = i + 1;
            }

        }
        return result;
    }

    public List<Integer> partitionLabels_mine(String S) {
        ArrayList<Integer> result = new ArrayList<>();
        int currentStart = 0;
        int currentLast = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            for (int j = S.length() - 1; j >= currentLast; j--) {
                if (S.charAt(j) == c) {
                    currentLast = j;
                    break;
                }
            }
            if (currentLast == i) {
                result.add(currentLast - currentStart + 1);
                currentStart = i + 1;
                currentLast = i + 1;
            }
        }
        return result;
    }
}
