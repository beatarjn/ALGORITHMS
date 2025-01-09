package leetcode;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    result[i] = Math.max(result[i], result[j] + 1);
                }
            }
        }
        return Arrays.stream(result).max().getAsInt();
    }
}
