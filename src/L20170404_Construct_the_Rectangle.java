/**
 * https://leetcode.com/problems/construct-the-rectangle/#/description
 */
public class L20170404_Construct_the_Rectangle {
    public int[] constructRectangle(int area) {
        int max = (int) Math.floor(Math.sqrt(area));
        for (int i = max; i >= 1; i--) {
            if (area % i == 0) {
                return new int[]{area / i, i};
            }
        }
        return new int[]{area, 1};
    }
}

