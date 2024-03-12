package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PartitionEqualSubsetSumTest {

    private PartitionEqualSubsetSum partitionEqualSubsetSum = new PartitionEqualSubsetSum();

    @ParameterizedTest
    @MethodSource("provideTestData")
    void test_canPartition(int[] nums, boolean expected) {

        boolean result = partitionEqualSubsetSum.canPartition(nums);

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void test_canPartitionDp(int[] nums, boolean expected) {

        boolean result = partitionEqualSubsetSum.canPartitionDp(nums);

        assertEquals(expected, result);
    }

    static Stream provideTestData() {
        return Stream.of(
                Arguments.of(new int[]{1, 5, 11, 5}, true),
                Arguments.of(new int[]{1, 2, 3, 5}, false),
                Arguments.of(new int[]{100}, false)
        );
    }
}