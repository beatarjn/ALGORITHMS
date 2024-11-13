package leetcode;

public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = Integer.MIN_VALUE;
        int counter = 0;
        for (int num : nums) {
            if (num == 0) {
                counter = 0;
            } else {
                counter++;
            }
            max = Math.max(max, counter);
        }
        return max;
    }
}
