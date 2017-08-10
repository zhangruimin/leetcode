package leetcode;

/**
 */
public class L2017051802_278_First_Bad_Version {

    class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int left = 1;
            int right = n;
            while (left <= right) {
                int mid = left + (right - left) / 2; //(left+high)/2 will cause overflow
                if (isBadVersion(mid)) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }

    class VersionControl {
        boolean isBadVersion(int mid) {
            return false;
        }
    }
}