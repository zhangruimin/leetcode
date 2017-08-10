package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 */
public class L2017080701_179_Largest_Number {
    public String largestNumber(int[] nums) {
        String collect = Arrays.stream(nums).boxed().sorted(((Comparator<Integer>) (o1, o2) -> {
            String s1 = String.valueOf(o1);
            String s2 = String.valueOf(o2);
            return (s1 + s2).compareTo(s2 + s1);
        }).reversed()).map(Object::toString).collect(Collectors.joining());
        if (collect.charAt(0) == '0') {
            return "0";
        }
        return collect;

    }

}

