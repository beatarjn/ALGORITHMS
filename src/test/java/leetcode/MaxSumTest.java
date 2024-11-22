package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxSumTest {

    private final MaxSum maxSum = new MaxSum();


    @ParameterizedTest
    @MethodSource("provideTestDataMax")
    void maxSubArraySum(int[] nums, int expected) {
        int result = maxSum.maxSum(nums);
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