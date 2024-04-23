package exercises.dynamic_programming;

public class Magnets {

    public int maxMagnetsForMoney(int[] magnets, int money) {
        int target = money - 2;
        int n = magnets.length;

        int[][] dp = new int[n][target + 1];
        for (int i = 0; i < target + 1; i++) {
            if (magnets[0] <= i) {
                dp[0][i] = magnets[0] * (i / magnets[0]);
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                int noTake = dp[i - 1][j];

                int take = 0;
                if (magnets[i] <= j) {
                    take = magnets[i] + dp[i][j - magnets[i]];
                }
                dp[i][j] = Math.max(take, noTake);
            }
        }
        return dp[n - 1][target];
    }

}