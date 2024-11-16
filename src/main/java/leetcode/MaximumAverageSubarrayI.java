package leetcode;

public class MaximumAverageSubarrayI {

    public double findMaxAverage(int[] nums, int k) {
        int max;
        int kSum = 0;

        for (int i = 0; i < k; i++) {
            kSum += nums[i];
        }
        max = kSum;

        for (int i = k; i < nums.length; i++) {
            kSum += (nums[i] - nums[i - k]);

            max = Math.max(max, kSum);
        }
        return max * 1.0 / k;
    }

    public int maxSum(int[] nums) {
        int r;
        int l = 0;
        int max = 0;
        int temp = nums[l] + nums[l + 1];

        for (r = 2; r < nums.length; r = l + 2) {
            max = Math.max(max, temp + nums[r]);
            temp = nums[r] + nums[r - 1];
            l++;
        }
        return max;
    }
}
