package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumLengthRepeatedSubarrayTest {

    private final MaximumLengthRepeatedSubarray maximumLengthRepeatedSubarray = new MaximumLengthRepeatedSubarray();

    @ParameterizedTest
    @MethodSource("provideTestData")
    void findLength(int[] nums1, int[] nums2, int expected) {
        int result = maximumLengthRepeatedSubarray.findLength(nums1, nums2);

        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}, 3),
                Arguments.of(new int[]{0, 0, 0, 0, 0}, new int[]{0, 0, 0, 0, 0}, 5)
        );
    }
}