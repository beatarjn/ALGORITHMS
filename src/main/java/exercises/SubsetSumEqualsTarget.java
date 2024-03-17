package exercises;

import java.util.Arrays;

public class SubsetSumEqualsTarget {
    public boolean subsetSumToTarget(int target, int[] arr){
        int ind = arr.length;
        return isSum(target, arr, ind-1);
    }

    private boolean isSum(int target, int[] arr, int ind) {
        if (target == 0) {
            return true;
        }

        if (ind == 0) {
            return arr[ind] == target;
        }

        boolean notTake = isSum(target, arr, ind - 1);
        boolean take = false;
        if (arr[ind] <= target) {
            take = isSum(target - arr[ind], arr, ind - 1);
        }
        return take || notTake;
    }
}
