package leetcode;

public class MergeStringsAlternately {

    public String mergeAlternately(String word1, String word2) {
        int i = 0;
        int j = 0;

        int n = word1.length();
        int m = word2.length();
        StringBuilder sb = new StringBuilder();

        while (i < n && j < m) {
            sb.append(word1.charAt(i++)).append(word2.charAt(j++));
        }

        if (i < n) {
            sb.append(word1.substring(i, n));
        }

        if (j < m) {
            sb.append(word2.substring(j, m));
        }

        return sb.toString();
    }
}