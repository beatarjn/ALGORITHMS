package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class AvgTest {

    private final Avg avgTest = new Avg();


    @ParameterizedTest
    @MethodSource("testData")
    void highFiveTest(int[][] nums, int[][] expected) {
        int[][] result = avgTest.highFive(nums);
        assertArrayEquals(expected, result);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][]{
                        {1, 100},
                        {7, 100},
                        {1, 100},
                        {7, 100},
                        {1, 100},
                        {7, 100},
                        {1, 100},
                        {7, 100},
                        {1, 100},
                        {7, 100}
                }, new int[][]{{1, 100}, {7, 100}}),
                Arguments.of(new int[][]{
                        {1, 91},
                        {1, 92},
                        {2, 93},
                        {2, 97},
                        {1, 60},
                        {2, 77},
                        {1, 65},
                        {1, 87},
                        {1, 100},
                        {2, 100},
                        {2, 76}
                }, new int[][]{{1, 87}, {2, 88}})
        );
    }

}