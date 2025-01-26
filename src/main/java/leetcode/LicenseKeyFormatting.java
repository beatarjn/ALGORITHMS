package leetcode;

public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int count = k;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != '-') {
                if (count == 0) {
                    sb.append('-');
                    count = k;
                }
                sb.append(s.charAt(i));
                count--;
            }
        }
        return sb.reverse().toString().toUpperCase();
    }
}