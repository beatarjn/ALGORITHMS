package exercises;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class LongestCommonSubstring {

    public int lcsLength(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n + 1][m + 1];
        return getLcs(text1, text2, n, m, dp);
    }

    private int getLcs(String text1, String text2, int n, int m, int[][] dp) {

        IntStream.range(0, n).forEach(i -> dp[i][0] = 0);
        IntStream.range(0, m).forEach(j -> dp[0][j] = 0);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = text1.charAt(i - 1) != text2.charAt(j - 1) ? 0 : dp[i - 1][j - 1] + 1;
            }
        }

        OptionalInt max = Arrays.stream(dp)
                .flatMapToInt(Arrays::stream)
                .parallel()
                .max();

        return max.isPresent() ? max.getAsInt() : 0;
    }
}
