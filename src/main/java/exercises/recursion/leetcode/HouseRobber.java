package exercises.recursion.leetcode;

import java.util.Arrays;

public class HouseRobber {

//    Input: nums = [1,2,3,1]
//    Output: 4
//    Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//    Total amount you can rob = 1 + 3 = 4.

    public int rob(int[] nums) {
        int n = nums.length - 1;

        return robRecursive(nums, n);
    }

    public int robMemo(int[] nums) {

        int n = nums.length - 1;
        int[] temp = new int[nums.length];
        Arrays.fill(temp, -1);

        return robRecursiveMemo(nums, n, temp);
    }

    private int robRecursive(int[] nums, int n) {
        if (n == 0) {
            return nums[n];
        }
        if (n < 0) {
            return 0;
        }
        int take = nums[n] + robRecursive(nums, n - 2);
        int notTake = robRecursive(nums, n - 1);

        return Math.max(take, notTake);
    }

    private int robRecursiveMemo(int[] nums, int n, int[] temp) {
        if (n == 0) {
            return nums[n];
        }

        if (n < 0) {
            return 0;
        }

        if (temp[n] != -1) {
            return temp[n];
        }

        int take = nums[n] + robRecursiveMemo(nums, n - 2, temp); //O(2^n)
        int notTake = robRecursiveMemo(nums, n - 1, temp);
        temp[n] = Math.max(take, notTake);
        return temp[n];
    }

    public int robDp(int[] nums) { //O(n)
        int[] temp = new int[nums.length];
        Arrays.fill(temp, -1);

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                temp[0] = nums[i];
            } else {
                int take = (i == 1) ? nums[i] : nums[i] + temp[i - 2];
                int notTake = temp[i - 1];
                temp[i] = Math.max(take, notTake);
            }
        }
        return temp[nums.length - 1];
    }

}