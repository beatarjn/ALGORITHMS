package leetcode;

import java.util.stream.IntStream;

public class OnesAndZeroes {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {

            int zeros = count(str, '0');
            int ones = count(str, '1');

            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }

    private int count(String strs, char c) {
        return (int) IntStream.range(0, strs.length())
                .filter(i -> strs.charAt(i) == c)
                .count();
    }
}