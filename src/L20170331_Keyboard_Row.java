import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/keyboard-row/#/description
 * Created by zrruimin on 3/31/17.
 */
public class L20170331_Keyboard_Row {
    public String[] findWords(String[] words) {
        String first = "qwertyuiop";
        String second = "asdfghjkl ";
        String third = "zxcvbnm";

        HashMap<Integer, Integer> map = new HashMap<>();

        initiate(first, map, 1);
        initiate(second, map, 2);
        initiate(third, map, 3);

        return Arrays.stream(words).filter( word ->inSameRow(word,map)).toArray(String[]::new);

    }

    private boolean inSameRow(String word, HashMap<Integer, Integer> map) {
        String s = word.toLowerCase();
        int row = map.get((int) s.charAt(0));
        for (int i = 0; i < s.length(); i++) {
            Integer r = map.get((int) s.charAt(i));
            if (r != row) {
                return false;
            }
        }
        return true;
    }

    private void initiate(String first, HashMap<Integer, Integer> map, int value) {
        for (int i = 0; i < first.length(); i++) {
            map.put((int) first.charAt(i), value);
        }
    }

}

