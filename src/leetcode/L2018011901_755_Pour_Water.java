package leetcode;

/**
 */
public class L2018011901_755_Pour_Water {
    public static void main(String[] args) {
        System.out.println(new L2018011901_755_Pour_Water().pourWater(new int[]{1, 2, 3, 4, 3, 2, 1, 2, 3, 4, 3, 2, 1}, 5, 2));
    }

    public int[] pourWater(int[] heights, int V, int K) {
        for (int i = 0; i < V; i++) {
            int l = findLeftIndex(heights, K);
            int r = findRightIndex(heights, K);
            int f = K;

            if (heights[l] < heights[f]) {
                f = l;
            } else if (heights[r] < heights[f]) {
                f = r;
            }
            heights[f]++;
        }
        return heights;
    }

    private int findRightIndex(int[] heights, int k) {
        int r = k;
        int i = k;
        while (i < heights.length - 1 && heights[i + 1] <= heights[i]) {
            if (heights[i + 1] < heights[i]) {
                r = i + 1;
            }
            i++;
        }
        return r;
    }

    private int findLeftIndex(int[] heights, int k) {
        int l = k;
        int i = k;
        while (i > 0 && heights[i - 1] <= heights[i]) {
            if (heights[i - 1] < heights[l]) {
                l = i - 1;
            }
            i--;
        }
        return l;
    }
}

