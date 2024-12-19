package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumPopulationYear {

    public int maximumPopulation(int[][] logs) {
        Arrays.sort(logs, Comparator.comparingInt(a -> a[0]));
        int[] entries = new int[2051];
        for (int[] log : logs) {
            entries[log[0]] += 1;
            entries[log[1] + 1] -= 1;
        }

        int maxVal = 0;
        int max = 0;
        for (int i = logs[0][0]; i < entries.length; i++) {
            entries[i] += entries[i - 1];

            if (entries[i] > maxVal) {
                max = i;
                maxVal = entries[i];
            }
        }
        return max;
    }
}
