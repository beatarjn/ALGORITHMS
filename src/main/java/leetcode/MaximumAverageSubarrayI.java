package leetcode;

import java.util.Arrays;

public class MaximumAverageSubarrayI {

    public double findMaxAverage(int[] nums, int k) {
        int max;
        int kSum = Arrays.stream(nums, 0, k).sum();

        max = kSum;

        for (int i = k; i < nums.length; i++) {
            kSum += (nums[i] - nums[i - k]);

            max = Math.max(max, kSum);
        }
        return max * 1.0 / k;
    }

}
