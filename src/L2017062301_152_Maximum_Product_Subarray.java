/**
 */
public class L2017062301_152_Maximum_Product_Subarray {
    public int maxProduct(int[] nums) {
        int maxPre = nums[0];
        int minPre = nums[0];
        int max = nums[0];


        for (int i = 1; i < nums.length; i++) {
            int maxHere = Math.max(Math.max(maxPre * nums[i], minPre * nums[i]), nums[i]);
            int minHere = Math.min(Math.min(maxPre * nums[i], minPre * nums[i]), nums[i]);
            max = Math.max(max, maxHere);
            maxPre=maxHere;
            minPre = minHere;
        }

        return max;
    }

    public int maxProduct_mine(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int currentProduct = nums[i];
            max = Math.max(currentProduct, max);
            for (int j = i + 1; j < nums.length; j++) {
                currentProduct *= nums[j];
                max = Math.max(currentProduct, max);
            }
        }
        return max;
    }
}

