package leetcode;

import java.util.Arrays;

public class UncrossedLines {

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        return getMax(n - 1, m - 1, nums1, nums2);
    }

    private int getMax(int n, int m, int[] nums1, int[] nums2) {
        if (n < 0 || m < 0) {
            return 0;
        }

        if (nums1[n] == nums2[m]) {
            return 1 + getMax(n - 1, m - 1, nums1, nums2);
        } else {
            return Math.max(getMax(n - 1, m, nums1, nums2), getMax(n, m - 1, nums1, nums2));
        }
    }

    public int maxUncrossedLinesDp(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int[][] dp = new int[n][m];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));

        return getMaxDp(n - 1, m - 1, nums1, nums2, dp);
    }

    private int getMaxDp(int n, int m, int[] nums1, int[] nums2, int[][] dp) {
        if (n < 0 || m < 0) {
            return 0;
        }

        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        if (nums1[n] == nums2[m]) {
            dp[n][m] = 1 + getMaxDp(n - 1, m - 1, nums1, nums2, dp);
            return dp[n][m];
        } else {
            dp[n][m] = Math.max(getMaxDp(n - 1, m, nums1, nums2, dp), getMaxDp(n, m - 1, nums1, nums2, dp));
            return dp[n][m];
        }
    }

    public int maxUncrossedLinesTab(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int[][] dp = new int[n + 1][m + 1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));

        return getMaxTab(n, m, nums1, nums2, dp);
    }

    private int getMaxTab(int n, int m, int[] nums1, int[] nums2, int[][] dp) {
        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;

        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }
}