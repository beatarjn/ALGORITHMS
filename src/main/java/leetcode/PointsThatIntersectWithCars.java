package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PointsThatIntersectWithCars {
    public int numberOfPoints(List<List<Integer>> nums) {
        Set<Integer> set = new HashSet<>();
        for (List<Integer> in : nums) {
            int left = in.get(0);
            int right = in.get(1);

            while (left <= right) {
                set.add(left);
                left++;
            }

        }
        return set.size();
    }
}
