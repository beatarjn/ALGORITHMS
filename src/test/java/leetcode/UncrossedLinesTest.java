package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UncrossedLinesTest {

    private UncrossedLines uncrossedLines = new UncrossedLines();

    @ParameterizedTest
    @MethodSource("provideTestData")
    void maxUncrossedLines(int[] nums1, int[] nums2, int expected) {
        int result = uncrossedLines.maxUncrossedLines(nums1, nums2);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void maxUncrossedLinesDp(int[] nums1, int[] nums2, int expected) {
        int result = uncrossedLines.maxUncrossedLinesDp(nums1, nums2);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void maxUncrossedLinesTab(int[] nums1, int[] nums2, int expected) {
        int result = uncrossedLines.maxUncrossedLinesTab(nums1, nums2);
        assertEquals(expected, result);
    }

    static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(new int[]{1, 4, 2}, new int[]{1, 2, 4}, 2),
                Arguments.of(new int[]{2, 5, 1, 2, 5}, new int[]{10, 5, 2, 1, 5, 2}, 3),
                Arguments.of(new int[]{1, 3, 7, 1, 7, 5}, new int[]{1, 9, 2, 5, 1}, 2)
        );
    }

}