package leetcode;

import java.util.Arrays;

public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int target;
        if (sum % 2 == 0) {
            target = sum / 2;
        } else {
            return false;
        }
        return getSubset(nums, target, nums.length - 1);
    }

    private boolean getSubset(int[] nums, int target, int ind) {
        if (target == 0) {
            return true;
        }

        if (ind == 0) {
            return nums[ind] == target;
        }

        boolean noTake = getSubset(nums, target, ind - 1);
        boolean take = false;
        if (target >= nums[ind]) {
            take = getSubset(nums, target - nums[ind], ind - 1);
        }
        return take || noTake;
    }

    public boolean canPartitionDp(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int target;
        if (sum % 2 == 0) {
            target = sum / 2;
        } else {
            return false;
        }

        int n = nums.length;

        boolean[][] dp = new boolean[n + 1][target + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= target; j++) {
                boolean noTake = dp[i - 1][j];
                boolean take = false;
                if (nums[i] <= j) {
                    take = dp[i - 1][j - nums[i]];
                }
                dp[i][j] = take || noTake;
            }
        }
        return dp[n - 1][target];
    }
}
