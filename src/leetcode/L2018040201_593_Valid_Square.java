package leetcode;

import java.util.ArrayList;
import java.util.Collections;

/**
 */
public class L2018040201_593_Valid_Square {
    public static void main(String[] args) {
        System.out.println(new L2018040201_593_Valid_Square().validSquare(new int[]{1134, -2539},
                new int[]{492, -1255}
                , new int[]{-792, -1897}
                , new int[]{-150, -3181}));
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        ArrayList<Integer> lengths = new ArrayList<>();
        lengths.add(getLength(p1, p2));
        lengths.add(getLength(p1, p3));
        lengths.add(getLength(p1, p4));
        lengths.add(getLength(p2, p3));
        lengths.add(getLength(p2, p4));
        lengths.add(getLength(p3, p4));
        Collections.sort(lengths);

        if (lengths.stream().anyMatch(e -> e == 0)) {
            return false;
        }


        if (!lengths.get(0).equals(lengths.get(1)) || !lengths.get(2).equals(lengths.get(3))||!lengths.get(0).equals(lengths.get(3))) {
            return false;
        }

        if (lengths.get(0) + lengths.get(2) != lengths.get(4)) {
            return false;
        }
        return true;
    }

    private int getLength(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}
