package leetcode;

public class MaxSum {

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
