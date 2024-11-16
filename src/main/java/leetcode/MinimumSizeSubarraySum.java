package leetcode;

import java.util.Arrays;

public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right;
        int sum = 0;
        int min = nums.length + 1;
        int l = 0;
        int r = 0;

        for (right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                if (right - left + 1 < min) {
                    l = left;
                    r = right;
                }
                min = Math.min(min, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        System.out.println(min == nums.length + 1 ? Arrays.toString(new int[]{}) : Arrays.toString(Arrays.copyOfRange(nums, l, r + 1)));
        return min == nums.length + 1 ? 0 : min;
    }

}