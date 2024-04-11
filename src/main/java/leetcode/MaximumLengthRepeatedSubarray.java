package leetcode;

import java.util.Arrays;
import java.util.OptionalInt;

public class MaximumLengthRepeatedSubarray {

    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int[][] dp = new int[n + 1][m + 1];

        return getMax(nums1, nums2, n, m, dp);
    }

    private int getMax(int[] nums1, int[] nums2, int n, int m, int[][] dp) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        OptionalInt max = Arrays.stream(dp)
                .flatMapToInt(Arrays::stream)
                .parallel()
                .max();

        return max.isPresent() ? max.getAsInt() : 0;
    }
}
