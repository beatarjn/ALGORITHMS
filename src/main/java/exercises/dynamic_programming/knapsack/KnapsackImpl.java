package exercises.dynamic_programming.knapsack;

public class KnapsackImpl {

    public static int getMaxValue(int[][] items, int target) {
        int[][] dp = new int[items.length][target];

        for (int i = 0; i < items.length; i++) {
            int weight = items[i][0];
            int value = items[i][1];
            for (int index = 0; index < target; index++) {
                if (weight > index + 1) {
                    if (i == 0) {
                        dp[i][index] = 0;
                    } else {
                        dp[i][index] = dp[i - 1][index];
                    }
                } else if (weight == index + 1) {
                    dp[i][index] = value;
                } else {
                    if (i == 0) {
                        dp[i][index] = value;
                    } else {
                        dp[i][index] = Math.max(dp[i - 1][index], dp[i - 1][index - weight] + value);
                    }
                }
            }
        }
        return dp[items.length - 1][target - 1];
    }
}