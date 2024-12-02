package leetcode;

import java.util.*;
import java.util.stream.IntStream;

public class SubstringWithConcatenationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int wordsCount = words.length;
        if (s.length() < wordsCount) {
            return result;
        }

        IntStream.range(0, wordsCount)
                .forEach(i -> map.put(words[i], map.getOrDefault(words[i], 0) + 1));

        int counter = wordsCount;
        int length = words[0].length();

        for (int i = 0; i < words.length; i++) {
            int l = i;
            int r = i;
            while (r < s.length()) {
                String word = s.substring(r, r + length);
                if (map.containsKey(word)) {
                    if (map.get(word) > 0) {
                        counter--;
                        map.put(word, map.get(word) - 1);
                    }
                }
                while (map.containsKey(word) && (wordsCount * length == r + 3 - l || map.get(word) < 0)) {
                    if (counter == 0) {
                        result.add(l);
                    }
                    String key = s.substring(l, l + length);
                    map.put(key, map.get(key) + 1);
                    l = l + length;
                    if (map.get(key) > 0) {
                        counter++;
                    }
                }
                r = r + length;
            }
        }
        return result;
    }


    public List<Integer> findSubstring1(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        int wordsCount = words.length;
        if (s.length() < wordsCount) {
            return result;
        }

        IntStream.range(0, wordsCount)
                .forEach(i -> map.put(words[i], map.getOrDefault(words[i], 0) + 1));

        int wordLength = words[0].length();

        for (int i = 0; i < s.length() - wordLength * wordsCount + 1; i++) {
            Map<String, Integer> seen = new HashMap<>();
            for (int j = 0; j < wordsCount; j++) {
                String word = s.substring(i + j * wordLength, i + (j + 1) * wordLength);
                if (map.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    if (seen.get(word) > map.get(word)) {
                        break;
                    }
                } else {
                    break;
                }
                if (j + 1 == wordsCount) {
                    result.add(i);
                }
            }
        }
        return result;
    }

    public List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int n = s.length();
        int m = words.length;
        int w = words[0].length();

        HashMap<String, Integer> map = new HashMap<>();
        Arrays.stream(words).forEach(x -> map.put(x, map.getOrDefault(x, 0) + 1));

        for (int i = 0; i < w; i++) {
            HashMap<String, Integer> temp = new HashMap<>();
            int count = 0;
            for (int j = i, k = i; j + w <= n; j = j + w) {
                String word = s.substring(j, j + w);
                temp.put(word, temp.getOrDefault(word, 0) + 1);
                count++;

                if (count == m) {
                    if (map.equals(temp)) {
                        ans.add(k);
                    }
                    String remove = s.substring(k, k + w);
                    temp.computeIfPresent(remove, (a, b) -> (b > 1) ? b - 1 : null);
                    count--;
                    k = k + w;
                }
            }
        }
        return ans;
    }
}
