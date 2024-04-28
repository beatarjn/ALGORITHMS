package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LengthOfTheLongestSubsequenceSumToTargetTest {

    private final LengthOfTheLongestSubsequenceSumToTarget length = new LengthOfTheLongestSubsequenceSumToTarget();

    @ParameterizedTest
    @MethodSource("provideTestData")
    void lengthOfTheLongestSubsequence(List<Integer> nums, int target, int expected) {
        int result = length.lengthOfTheLongestSubsequence(nums, target);

        assertEquals(expected, result);
    }

    static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(Arrays.asList(4, 1, 3, 2, 1, 5), 7, 4),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5), 9, 3),
                Arguments.of(Arrays.asList(1, 1, 5, 4, 5), 3, -1),
                Arguments.of(Arrays.asList(1000), 1000, 1),
                Arguments.of(Arrays.asList(9, 15, 8, 14, 11, 7, 13, 9, 4), 48, 6)
        );
    }

}