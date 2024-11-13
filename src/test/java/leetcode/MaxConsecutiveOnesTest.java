package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxConsecutiveOnesTest {

    private final MaxConsecutiveOnes maxConsecutiveOnes = new MaxConsecutiveOnes();

    public static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 0, 1, 1, 1}, 3),
                Arguments.of(new int[]{1, 0, 1, 1, 0, 1}, 2),
                Arguments.of(new int[]{0, 0, 0}, 0),
                Arguments.of(new int[]{1, 1}, 2),
                Arguments.of(new int[]{0, 0, 0, 1}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    void findMaxConsecutiveOnes(int[] nums, int expected) {
        int result = maxConsecutiveOnes.findMaxConsecutiveOnes(nums);

        assertEquals(expected, result);
    }
}