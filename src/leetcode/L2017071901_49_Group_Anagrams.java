package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 */
public class L2017071901_49_Group_Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String key = getKey(str);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }

        return new ArrayList<>(map.values());

    }

    private String getKey(String str) {
        int[] counts = new int[26];
        for (char c : str.toCharArray()) {
            counts[c - 'a']++;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                for (int j = 0; j < counts[i]; j++) {
                    sb.append((char) ('a' + i));
                }
            }
        }
        return sb.toString();
    }
}

