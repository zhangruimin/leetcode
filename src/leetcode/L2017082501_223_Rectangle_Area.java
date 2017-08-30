package leetcode;

/**
 */
public class L2017082501_223_Rectangle_Area {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int first = computeArea(A, B, C, D);
        int second = computeArea(E, F, G, H);
        int relativePosition = relativePosition(A, B, C, D, E, F, G, H);
        switch (relativePosition) {
            case 1:
                return first;
            case 2:
                return second;
            case 3:
                return first + second;
        }

        return first + second - getCommonArea(A, B, C, D, E, F, G, H);
    }

    private int getCommonArea(int a, int b, int c, int d, int e, int f, int g, int h) {
        int rl = Math.max(a, e);
        int cl = Math.max(b, f);
        int rr = Math.min(c, g);
        int cr = Math.min(d, h);

        return computeArea(rl, cl, rr, cr);
    }

    private int relativePosition(int a, int b, int c, int d, int e, int f, int g, int h) {
        if (a <= e && c >= g && b <= f && d >= h) {
            return 1;
        }

        if (a >= e && c <= g && b >= f && d <= h) {
            return 2;
        }

        if (a >= g || c <= e || d <= f || h <= b) {
            return 3;
        }
        return 0;
    }

    private int computeArea(int a, int b, int c, int d) {
        return (c - a) * (d - b);
    }
}

