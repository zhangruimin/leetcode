import java.util.Arrays;

/**
 */
public class L2017051302_455_Assign_Cookies {
    public int findContentChildren(int[] g, int[] s) {
        if (g.length == 0 || s.length == 0) {
            return 0;
        }

        Arrays.sort(g);
        Arrays.sort(s);

        int childIndex = 0;
        int cookieIndex = 0;

        while (childIndex < g.length && cookieIndex < s.length) {
            if (g[childIndex] <= s[cookieIndex]) {
                childIndex++;
                cookieIndex++;
                continue;
            }else{
                cookieIndex++;
            }
        }
        return childIndex;
    }
}





