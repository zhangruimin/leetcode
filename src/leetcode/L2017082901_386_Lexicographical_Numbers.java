package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class L2017082901_386_Lexicographical_Numbers {
    public List<Integer> lexicalOrder(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        int current = 1;
        for (int i = 1; i <= n; i++) {
            result.add(current);
            int n1 = current * 10;
            if (n1 <= n) {
                current = n1;
            } else if (current % 10 != 9 && current + 1 <= n) {
                current++;
            } else {
                while ((current / 10) % 10 == 9) {
                    current /= 10;
                }
                current = current / 10 + 1;
            }
        }
        return result;
    }
}

