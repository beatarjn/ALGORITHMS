package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestIncreasingSubsequenceTest {

    private final LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();

    @ParameterizedTest
    @MethodSource("testData")
    void lengthOfLIS(int[] nums, int expected) {
        int result = longestIncreasingSubsequence.lengthOfLIS(nums);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{10, 9, 2, 5, 3, 7, 101, 18}, 4),
                Arguments.of(new int[]{0, 1, 0, 3, 2, 3}, 4),
                Arguments.of(new int[]{7, 7, 7, 7, 7, 7, 7}, 1)
        );
    }
}