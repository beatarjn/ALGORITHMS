package exercises;

public class SubsetSum {

    public boolean subsetSumToK(int n, int k, int[] arr) {
        if (k == 0) {
            return true;
        }

        if (n == 0) {
            return arr[n] == k;
        }

        boolean noTake = subsetSumToK(n - 1, k, arr);
        boolean take = false;
        if (k >= arr[n]) {
            take = subsetSumToK(n - 1, k - arr[n], arr);
        }

        return take || noTake;
    }


}
