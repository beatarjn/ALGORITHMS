package leetcode;

import java.util.List;

public class LengthOfTheLongestSubsequenceSumToTarget {

    public int lengthOfTheLongestSubsequence(List<Integer> nums, int target) {

        int n = nums.size();
        int[][] dp = new int[n + 1][target + 1];
        for (int j = 1; j <= target; j++) {
            dp[0][j] = -1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums.get(i - 1) <= j && dp[i - 1][j - nums.get(i - 1)] != -1) {
                    dp[i][j] = Math.max(1 + dp[i - 1][j - nums.get(i - 1)], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][target];
    }
}