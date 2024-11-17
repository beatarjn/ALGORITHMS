package leetcode;

import java.util.*;

public class RepeatedDNASequences {

    public List<String> findRepeatedDnaSequences(String s) {
        int length = 10;
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            int end = i + length;
            if (end <= s.length()) {
                String temp = s.substring(i, end);
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    public List<String> findRepeatedDnaSequencesII(String s) {
        int length = 10;
        List<String> result = new ArrayList<>();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            int end = i + length;
            if (end <= s.length()) {
                String temp = s.substring(i, end);
                boolean found = set.add(temp);
                if (!found && !result.contains(temp)) {
                    result.add(temp);
                }
            }
        }
        return result;
    }
}
