package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LongestHarmoniousSubsequenceTest {

    private final LongestHarmoniousSubsequence longestHarmoniousSubsequence = new LongestHarmoniousSubsequence();

    @ParameterizedTest
    @MethodSource("testData")
    void findLHS(int[] nums, int expected) {
        int result = longestHarmoniousSubsequence.findLHS(nums);

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("testData")
    void findLHSSlidding(int[] nums, int expected) {
        int result = longestHarmoniousSubsequence.findLHSSlidding(nums);

        assertEquals(expected, result);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{1,3,2,2,5,2,3,7}, 5),
                Arguments.of(new int[]{1,2,3,4}, 2),
                Arguments.of(new int[]{1,1,1,1}, 0)
        );
    }


}