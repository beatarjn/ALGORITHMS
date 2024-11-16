package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            if (map.containsKey(num + 1)) {
                max = Math.max(max, map.get(num) + map.get(num + 1));
            }
        }
        return max;
    }

    public int findLHSSlidding(int[] nums) {
        int max = 0;
        int l = 0;
        int r;
        int sum;

        Arrays.sort(nums);

        for (r = 1; r < nums.length; r++) {
            sum = nums[r] - nums[l];
            while (sum > 1) {
                l++;
                sum = nums[r] - nums[l];
            }
            if (sum == 1 || sum == -1) {
                max = Math.max(max, r - l + 1);
            }
        }
        return max;

    }
}
