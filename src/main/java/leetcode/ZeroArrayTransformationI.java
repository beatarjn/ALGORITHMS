package leetcode;

public class ZeroArrayTransformationI {
    public boolean isZeroArrayUsingPrefixSum(int[] nums, int[][] queries) {
//        Prefix Sum Array for Updates:
//        For each query [l, r], decrement the value at index l (ps[l] -= 1) to indicate a decrease
//        for the range.
//        Increment the value at index r+1 (ps[r+1] += 1) to cancel out the decrease after index r.
//
//        Cumulative Sum:
//        Compute the cumulative sum of the ps [ ] array to derive the actual decrements applied to
//        each index of nums.
//
//        Validation:
//        Traverse the array a and check if a[i] + ps[i] > 0. If any value is greater than zero,
//        return false as a cannot be reduced to zero. Otherwise, return true.

        int n = nums.length;
        int[] ps = new int[n + 1];
        for (int[] i : queries) {
            ps[i[0]] -= 1;
            ps[i[1] + 1] += 1;
        }
        for (int i = 1; i < n; i++) {
            ps[i] += ps[i - 1];
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] + ps[i] > 0)
                return false;
        }
        return true;
    }
}
