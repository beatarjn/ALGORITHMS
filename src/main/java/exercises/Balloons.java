package exercises;

import java.util.Arrays;

public class Balloons {

    public int getMaxRecValue(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return getMaxRec(nums, n-1, dp);
    }

    private int getMaxRec(int[] nums, int ind, int[] dp) {
        if (ind == 0) {
            return nums[0];
        }

        if (dp[ind] != -1) {
            return dp[ind];
        }

        int notTake = getMaxRec(nums, ind - 1, dp);

        int take = Integer.MIN_VALUE;

        if (ind >= 2) {
            take = nums[ind] + getMaxRec(nums, ind - 2, dp);
        }
        dp[ind] = Math.max(notTake, take);
        return Math.max(notTake, take);
    }

    public int getMaxDpValue(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return getMaxDp(nums, n-1, dp);
    }

    private int getMaxDp(int[] nums, int ind, int[] dp) {
        dp[0] = nums[0];

        int notTake;
        int take = nums[0];
        for (int i = 1; i < nums.length; i++) {
            notTake = dp[i - 1];

            if (i >= 2) {
                take = nums[i] + dp[i - 2];
            }
            dp[i] = Math.max(notTake, take);
        }
        return dp[ind];
    }
}
