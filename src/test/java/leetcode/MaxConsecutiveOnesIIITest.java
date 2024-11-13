package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxConsecutiveOnesIIITest {

    private final MaxConsecutiveOnesIII maxConsecutiveOnes = new MaxConsecutiveOnesIII();

    public static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3, 10),
                Arguments.of(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2, 6)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    void findMaxConsecutiveOnes(int[] nums, int k, int expected) {
        int result = maxConsecutiveOnes.longestOnes(nums, k);

        assertEquals(expected, result);
    }
}