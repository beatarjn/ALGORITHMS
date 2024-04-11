package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumSizeSubarraySumTest {

    private final MinimumSizeSubarraySum minimumSizeSubarraySum = new MinimumSizeSubarraySum();

    @ParameterizedTest
    @MethodSource("provideTestData")
    void minSubArrayLen(int[] nums, int target, int expected) {
        int result = minimumSizeSubarraySum.minSubArrayLen(target, nums);
        assertEquals(expected, result);
    }

    static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(new int[]{2, 3, 1, 2, 4, 3}, 7, 2),
                Arguments.of(new int[]{1, 4, 4}, 4, 1),
                Arguments.of(new int[]{1, 1, 1, 1, 1, 1, 1, 1}, 11, 0),
                Arguments.of(new int[]{2, 16, 14, 15}, 20, 0),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 9, 2)
        );
    }
}