package exercises.dynamic_programming;

import java.util.Objects;

public class IngredientsMove {

    public int minNumberOfChanges(String[] availableIngredients, String[] recipeIngredients) {
        int n = availableIngredients.length;
        int m = recipeIngredients.length;

        int[][] dp = new int[n + 1][m + 1];

        int moves = getNumberOfMoves(n, m, availableIngredients, recipeIngredients, dp);

        return Math.abs(n - moves) + Math.abs(m - moves);
    }

    private int getNumberOfMoves(int n, int m, String[] available, String[] recipe, int[][] dp) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (Objects.equals(available[i - 1], recipe[j - 1])) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }
}