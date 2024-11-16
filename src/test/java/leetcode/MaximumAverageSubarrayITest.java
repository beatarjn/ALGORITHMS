package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumAverageSubarrayITest {

    private final MaximumAverageSubarrayI maximumAverageSubarrayI = new MaximumAverageSubarrayI();

    @ParameterizedTest
    @MethodSource("provideTestData")
    void findMaxAverage(int[] nums, int k, double expected) {
        double result = maximumAverageSubarrayI.findMaxAverage(nums, k);

        assertEquals(expected, result);
    }

    static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(new int[]{1, 12, -5, -6, 50, 3}, 4, 12.7500),
                Arguments.of(new int[]{5}, 1, 5.000)
        );
    }


    @ParameterizedTest
    @MethodSource("provideTestDataMax")
    void maxSubArraySum(int[] nums, int expected) {
        int result = maximumAverageSubarrayI.maxSum(nums);
        assertEquals(expected, result);
    }

    static Stream<Arguments> provideTestDataMax() {
        return Stream.of(
                Arguments.of(new int[]{6, 2, 3, 4, 7, 2, 1, 7, 1}, 14),
                Arguments.of(new int[]{10, -2, 13, -4, 1}, 21),
                Arguments.of(new int[]{2, 1, 0, 5, 4, 10}, 19)
        );
    }
}