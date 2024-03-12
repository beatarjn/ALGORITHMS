package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SetMatrixZeroesTest {
    private SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();
    @ParameterizedTest
    @MethodSource("provideTestData")
    void setZeroes(int[][] nums, int[][] expected) {
        int[][] result = setMatrixZeroes.setZeroes(nums);
        assertArrayEquals(expected, result);
    }

    static Stream<Arguments> provideTestData() {
        int[][] num1 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] expected1 = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        int[][] num2 = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        int[][] expected2 = {{0, 0, 0, 0}, {0, 4, 5, 0}, {0, 3, 1, 0}};
        int[][] num3 = {{0, 1}};
        int[][] expected3 = {{0, 0}};

        return Stream.of(
                Arguments.of(num1, expected1),
                Arguments.of(num2, expected2),
                Arguments.of(num3, expected3)
        );
    }
}