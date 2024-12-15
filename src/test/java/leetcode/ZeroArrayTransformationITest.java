package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ZeroArrayTransformationITest {
    private final ZeroArrayTransformationI zeroArrayTransformationI = new ZeroArrayTransformationI();

    @ParameterizedTest
    @MethodSource("testData")
    void isZeroArray(int[] nums, int[][] queries, boolean expected) {
        boolean result = zeroArrayTransformationI.isZeroArrayUsingPrefixSum(nums, queries);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{1, 0, 1}, new int[][]{{0, 2}}, true),
                Arguments.of(new int[]{4, 3, 2, 1}, new int[][]{{1, 3}, {0, 2}}, false),
                Arguments.of(new int[]{2}, new int[][]{{0, 0}, {0, 0}}, true)
        );
    }
}