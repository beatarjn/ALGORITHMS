package exercises.recursion.leetcode;

import java.util.Arrays;

public class NonOverlappingLineSegments {


    //    With N = 1, i.e, single point, there is no way to create a line segment.
//
//    With K >= N, Numbers of ways is zero because for K non-overlapping line segments in 1D plane, it requires at least K+1 points.
//
//    With K = N-1, there is always one way, i.e, 0-1, 1-2, 2-3, ..., (N-1)-N
//
//    With K = 1, N * (N-1)/2 ways are possible. For example, with N=5, K=1 ->
//
//            0-1, 0-2, 0-3, 0-4,
//            1-2, 1-3, 1-4
//            2-3, 2-4
//            3-4
//    For every pair (i,j) , number of ways are number of ways with (i-1, j) + number of ways with (for every 0 to i-1, j-1). For example with N = 5, K = 2,
//
//5 ways with (i-1, j) -> (4, 2) -> (0-1,1-2), (0-1,1-3), (0-1,2-3), (1-2,2-3), (0-2,2-3)
//            6 ways with (i-1,j-1) -> (4,1) -> (0-1,3-4), (0-2,3-4), (0-3,3-4), (1-2,3-4), (1-3,3-4), (2-3,3-4)
//            3 ways with (i-2,j-1) -> (3,1) -> (0-1,2-4), (1-2,2-4), (0-2,2-4)
//            1 way with (i-3,j-1) -> (2,1) -> (0-1,1-4)
//    Total ways = 5+ 6+ 3+ 1 = 15
//    I am adding dp[i][j] += dp[i-1][j] for cumulative sum, for better complexity.

    public static int numberOfSets1(int n, int k) {
        long mod = 1000000007;
        if (k == 1) {
            return n * (n - 1) / 2;
        }
        long[][] dp = new long[n][k];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + (i * (i + 1)) / 2;
        }
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i && j < k; j++) {
                dp[i][j] = dp[i - 1][j] - dp[i - 2][j] + dp[i - 1][j - 1] + mod;
                dp[i][j] %= mod;
                dp[i][j] += dp[i - 1][j];
            }
        }
        return (int) (dp[n - 1][k - 1] - dp[n - 2][k - 1]);
    }


    //doesn't work
    public static int numberOfSets(int n, int k) {
        int[][] temp = new int[n + 1][k + 1];
        Arrays.stream(temp).forEach(row -> Arrays.fill(row, -1));

        return count(n, k, temp);
    }

    private static int count(int n, int k, int[][] dp) {
        if (k == 1) {
            return dp[n][k] = (n * (n - 1)) / 2;
        }

        if (n == 1) {
            return 0;
        }

        if (n - 1 == k) {
            return 1;
        }

        if (n - 1 < k) {
            return 0;
        }

        if (dp[n][k] != -1) {
            return dp[n][k];
        }

        int sum = 0;

        sum = sum + count(n - 1, k, dp);
        for (int i = 0; i < n; i++) {
            sum = sum + count(n - 1, k - 1, dp);
        }

        return dp[n][k] = sum;
    }


}
