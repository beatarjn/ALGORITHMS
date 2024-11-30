package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        String result = "";
        Map<Character, Integer> map = new HashMap<>();

        if (n > m) {
            return result;
        }

        for (int i = 0; i < n; i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int counter = t.length();
        int l = 0;
        int start = 0;
        int r = 0;
        int minLength = Integer.MAX_VALUE;
        while (r < m) {
            char key = s.charAt(r);
            if (map.containsKey(key) && map.get(key) > 0) {
                counter--;
            }
            map.put(key, map.getOrDefault(key, 0) - 1);
            r++;

            while (counter == 0) {
                if (r - l < minLength) {
                    minLength = r - l;
                    start = l;
                }

                char leftChar = s.charAt(l);
                map.put(leftChar, map.getOrDefault(leftChar, 0) + 1);

                if (map.get(leftChar) > 0) {
                    counter++;
                }
                l++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}