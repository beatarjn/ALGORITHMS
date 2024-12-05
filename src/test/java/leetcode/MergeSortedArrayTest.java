package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeSortedArrayTest {

    private final MergeSortedArray mergeSortedArray = new MergeSortedArray();

    @ParameterizedTest
    @MethodSource("testData")
    void merge(int[] nums1, int m, int [] nums2, int n, int[] expected) {
        int[] result = mergeSortedArray.merge(nums1, m, nums2, n);
        assertArrayEquals(expected, result);
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3, new int[]{1, 2, 2, 3, 5, 6}),
                Arguments.of(new int[]{0}, 0, new int[]{1}, 1, new int[]{1}),
                Arguments.of(new int[]{1}, 1, new int[]{}, 0, new int[]{1}),
                Arguments.of(new int[]{2,0}, 1,new int[]{1}, 1, new int[]{1,2})
        );
    }
}