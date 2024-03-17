package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TwoSumTest {

    private TwoSum twoSum = new TwoSum();

    @ParameterizedTest
    @MethodSource("provideTestData")
    void twoSum(int[] nums, int target, int[] expected) {
        int[] result = twoSum.twoSum(nums, target);
        assertArrayEquals(expected, result);
    }

    static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(new int[]{11, 15, 2, 7}, 9, new int[]{2,3}),
                Arguments.of(new int[]{3, 2, 4}, 6, new int[]{1, 2}),
                Arguments.of(new int[]{3, 3}, 6, new int[]{0, 1})
        );
    }
}