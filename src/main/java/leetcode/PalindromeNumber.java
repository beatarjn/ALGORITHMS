package leetcode;

public class PalindromeNumber {

    public boolean isPalindromeString(int x) {
        String number = String.valueOf(x);

        StringBuilder sb = new StringBuilder(number);

        return number.contentEquals(sb.reverse());
    }

    public boolean isPalindrome(int x) {
        int digit = 0;
        int number = x;

        while (x > 0) {
            int last = x % 10;
            digit = digit * 10 + last;
            x = x / 10;
        }
        return number == digit;
    }
}
