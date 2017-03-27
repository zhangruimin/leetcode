/**
 * https://leetcode.com/problems/next-permutation/#/description
 * Created by zrruimin on 3/26/17.
 */
public class L20170326_NextPermutation {
    public static void main(String[] args) {
        L20170326_NextPermutation nextPermutation = new L20170326_NextPermutation();
        int[] nums = {5, 6, 9, 7, 4, 3};
        nextPermutation.nextPermutation(nums);
        System.out.print(nums);

    }


    public void nextPermutation(int[] nums) {
        int current = nums.length -1;
        while(current > 0){
            if (nums[current] > nums[current - 1]){
                int next = findPositionToSwitch(nums, current - 1);
                switchPosition(nums, next, current - 1);
                break;
            }
            current --;
        }

        reverse(nums, current);
    }

    private int findPositionToSwitch(int[] nums, int start){
        int current = nums.length - 1;
        while(current > start) {
            if(nums[current] > nums[start]){
                return current;
            }
            current --;
        }
        return current;
    }

    private void switchPosition(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    private void reverse(int[] nums, int start){
        int half = (nums.length-start) / 2;
        for(int i = 0; i < half; i++){
            switchPosition(nums, start + i, nums.length - 1 - i);
        }

        String s = new StringBuffer(234).reverse().toString();
    }
}
