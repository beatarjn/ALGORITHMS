package leetcode;

import java.util.Arrays;

public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        return lcs(n - 1, m - 1, text1, text2);
    }

    private int lcs(int n, int m, String text1, String text2) {
        if (n < 0 || m < 0) {
            return 0;
        }

        if (text1.charAt(n) == text2.charAt(m)) {
            return 1 + lcs(n - 1, m - 1, text1, text2);
        } else {
            return Math.max(lcs(n - 1, m, text1, text2), lcs(n, m - 1, text1, text2));
        }
    }

    public int longestCommonSubsequenceDp(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n + 1][m + 1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));

        return lcsDp(n - 1, m - 1, text1, text2, dp);
    }

    private int lcsDp(int n, int m, String text1, String text2, int[][] dp) {
        if (n < 0 || m < 0) {
            return 0;
        }

        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        if (text1.charAt(n) == text2.charAt(m)) {
            dp[n][m] = 1 + lcsDp(n - 1, m - 1, text1, text2, dp);
            return dp[n][m];
        } else {
            dp[n][m] = Math.max(lcsDp(n - 1, m, text1, text2, dp), lcsDp(n, m - 1, text1, text2, dp));
            return dp[n][m];
        }
    }

    public int longestCommonSubsequenceTab(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n + 1][m + 1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));

        return lcsTab(n, m, text1, text2, dp);
    }

    private int lcsTab(int n, int m, String text1, String text2, int[][] dp) {
        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;

        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }


}
