import java.util.*;

/**
 */
public class L2017050102_451_Sort_Characters_By_Frequency {
    public String frequencySort(String s) {
        Map<Character, Integer> hash = new HashMap<>();
        for (char c : s.toCharArray()) {
            Integer count = hash.getOrDefault(c, 0);
            hash.put(c, count + 1);
        }

        Set<Map.Entry<Character, Integer>> entries = hash.entrySet();
        ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<>(entries);
        list.sort(Comparator.comparing(Map.Entry::getValue));
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<Character, Integer> entry : list) {
            for (int i = 0; i < entry.getValue(); i++) {
                stringBuffer.append(entry.getKey());
            }
        }
        return stringBuffer.reverse().toString();
    }
}





