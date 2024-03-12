package leetcode;

public class ReverseInteger {

    public int reverse(int x) {
        long reversed = 0;

        while (x != 0) {
            int lastDigit = x % 10;
            x = x / 10;
            reversed = reversed * 10 + lastDigit;
        }
        if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) reversed;
    }
}