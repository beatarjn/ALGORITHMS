package leetcode;

public class CountPrimes {

    public int countPrimes(int n) {
        int counter = 0;
        for (int i = 0; i < n; i++) {
            if (isPrime(i)) {
                counter++;
            }
        }
        return counter;
    }

    private boolean isPrime(int n) {
        int counter = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                counter++;
                if (n / i != i) {
                    counter++;
                }
            }
        }
        return counter == 2;
    }
}