package exercises.recursion;

public class LCS {

    public int longestCommonSubsequence(String text1, String text2) {

        char[] one = text1.toCharArray();
        char[] two = text2.toCharArray();
        int[][] array = new int[text1.length() + 1][text2.length() + 1];

        for (int first = 0; first <= text1.length(); first++) {
            for (int second = 0; second <= text2.length(); second++) {
                if (first == 0 || second == 0) {
                    array[first][second] = 0;
                } else if (one[first - 1] == two[second - 1]) {
                    array[first][second] = array[first - 1][second - 1] + 1;
                } else {
                    array[first][second] = Math.max(array[first - 1][second], array[first][second - 1]);
                }
            }
        }
        return array[one.length][two.length];
    }
}
