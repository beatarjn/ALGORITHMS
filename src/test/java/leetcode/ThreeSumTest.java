package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ThreeSumTest {

    private final ThreeSum threeSum = new ThreeSum();

    @ParameterizedTest
    @MethodSource("testData")
    void threeSum(int[] nums, List<List<Integer>> expected) {
        List<List<Integer>> result = threeSum.threeSum(nums);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{-1, 0, 1, 2, -1, -4}, asList(
                        asList(-1, -1, 2),
                        asList(-1, 0, 1))),
                Arguments.of(new int[]{0, 1, 1}, Collections.emptyList()),
                Arguments.of(new int[]{0, 0, 0}, asList(
                        asList(0, 0, 0)))
        );
    }
}