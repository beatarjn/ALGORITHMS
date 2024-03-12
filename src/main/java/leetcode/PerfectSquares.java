package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PerfectSquares {

    public int numSquares(int n) {
        List<Integer> perfectSquares = countPerfectSquares(n);

        int size = perfectSquares.size();
        int ans = count(perfectSquares, n, size - 1);

        if (ans <= Integer.MAX_VALUE) {
            return ans;
        } else {
            return -1;
        }
    }

    private int count(List<Integer> nums, int amount, int n) {
        if (n == 0) {
            if (amount % nums.get(n) == 0) {
                return amount / nums.get(n);
            } else {
                return Integer.MAX_VALUE;
            }
        }

        int include = Integer.MAX_VALUE;
        if (nums.get(n) <= amount) {
            include = 1 + count(nums, amount - nums.get(n), n);
        }
        int exclude = count(nums, amount, n - 1);

        return Math.min(include, exclude);
    }

    private List<Integer> countPerfectSquares(int n) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            int sr = (int) Math.sqrt(i);
            if ((sr * sr) == i) {
                list.add(i);
            }
        }
        return list;
    }

    public int numSquaresDp(int n) {
        List<Integer> perfectSquares = countPerfectSquares(n);
        return countDp(perfectSquares, n);
    }

    private int countDp(List<Integer> nums, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < nums.size(); j++) {
                if (nums.get(j) <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - nums.get(j)]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public int numSquaresRec(int n) {
        return solveRec(n);
    }

    public int solveRec(int n) {
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return Integer.MAX_VALUE;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            ans = Math.min(ans, 1 + solveRec(n - (i * i)));
        }
        return ans;
    }


    public int numSquaresMemo(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solveMemo(n, dp);
    }

    public int solveMemo(int n, int[] memo) {
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return Integer.MAX_VALUE;
        }

        if (memo[n] != -1) {
            return memo[n];
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            ans = Math.min(
                    ans,
                    1 + solveMemo(n - (i * i), memo)
            );
        }
        memo[n] = ans;
        return memo[n];
    }

}