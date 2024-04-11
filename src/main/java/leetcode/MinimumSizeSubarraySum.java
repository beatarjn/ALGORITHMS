package leetcode;

import static java.lang.Math.min;

public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n + 1][target + 1];

        return getMin(n, nums, target, dp);
    }

    private int getMin(int n, int[] nums, int target, int[][] dp) {

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i - 1] == j) {
                    dp[i][j] = 1;
                }
                if (nums[i - 1] < j) {
                    if (dp[i - 1][j - nums[i - 1]] != 0) {
                        dp[i][j] = dp[i - 1][j - nums[i - 1]] + 1;
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n + 1; i++) {
            if (dp[i][target] != 0) {
                min = min(min, dp[i][target]);
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
