package leetcode;

public class MaxConsecutiveOnesIII {

    public int longestOnes(int[] nums, int k) {
        int l = 0;
        int max = Integer.MIN_VALUE;
        int r;
        int zeros = 0;

        for (r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                zeros++;
            }

            if (zeros > k) {
                if (nums[l] == 0) {
                    zeros--;
                }
                l++;
            }

            if (zeros <= k) {
                max = Math.max(max, r - l + 1);
            }
        }
        return max;
    }
}
