package leetcode;

import java.util.Arrays;

public class CoinChange {

    //not working correctly yet
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int ans = coinCount(coins, amount, n - 1);

        if (ans <= Integer.MAX_VALUE) {
            return ans;
        } else {
            return -1;
        }
    }

    private int coinCount(int[] coins, int amount, int n) {
        if (n == 0) {
            if (amount % coins[0] == 0) {
                return amount / coins[0];
            } else {
                return Integer.MAX_VALUE;
            }
        }

        int include = Integer.MAX_VALUE;
        if (coins[n] <= amount) {
            include = 1 + coinCount(coins, amount - coins[n], n);
        }
        int exclude = coinCount(coins, amount, n - 1);

        return Math.min(include, exclude);
    }

    public int coinChangeOptimized(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, max);

        dp[0] = 0;

        for (int i = 1; i <= amount ; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}