package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        var l = 0;
        var max = 0;

        for (int r = 0; r < s.length(); r++) {
            char key = s.charAt(r);
            if (!map.containsKey(key)) {
                max = Math.max(max, r - l + 1);
            } else {
                if (map.get(key) < l) {
                    max = Math.max(max, r - l + 1);
                } else {
                    l = map.get(key) + 1;
                }
            }
            map.put(key, r);
        }
        return max;
    }
}
