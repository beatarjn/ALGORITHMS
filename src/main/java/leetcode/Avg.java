package leetcode;

import java.util.*;

public class Avg {


    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map = new TreeMap<>();

        for (int i = 0; i < items.length; i++) {
            if (map.containsKey(items[i][0])) {
                PriorityQueue<Integer> values = map.get(items[i][0]);
                values.add(items[i][1]);
                map.put(items[i][0], values);
            } else {
                PriorityQueue<Integer> values = new PriorityQueue<>(Collections.reverseOrder());
                values.add(items[i][1]);
                map.put(items[i][0], values);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        map.keySet().forEach(key -> {
            int sum = map.get(key).stream().limit(5).mapToInt(Integer::intValue).sum();
            result.add(List.of(key, sum / 5));
        });

        return convertToArray(result);
    }

    private static int[][] convertToArray(List<List<Integer>> result) {
        int rows = result.size();
        int cols = result.get(0).size();

        int[][] array = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = result.get(i).get(j);
            }
        }
        return array;
    }
}