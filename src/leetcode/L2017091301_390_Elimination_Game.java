package leetcode;

/**
 */
public class L2017091301_390_Elimination_Game {
    public int lastRemaining(int n) {
        boolean left = true;
        int head = 1;
        int step = 1;
        int remaining = n;
        while (remaining > 1) {
            if (left || remaining % 2 == 1) {
                head += step;
            }
            step *= 2;
            left = !left;
            remaining = remaining / 2;
        }
        return head;
    }

}

