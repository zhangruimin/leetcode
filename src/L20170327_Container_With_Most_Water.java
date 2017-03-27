import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/container-with-most-water/#/description
 * Created by zrruimin on 3/26/17.
 */
public class L20170327_Container_With_Most_Water {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            if (area > max) {
                max = area;
            }
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
