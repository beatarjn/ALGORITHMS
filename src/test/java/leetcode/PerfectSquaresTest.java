package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PerfectSquaresTest {

    private PerfectSquares perfectSquares = new PerfectSquares();

    @ParameterizedTest
    @MethodSource("provideTestData")
    void test_numSquares(int number, int expected) {
        int result = perfectSquares.numSquares(number);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void test_numSquaresDp(int number, int expected) {
        int result = perfectSquares.numSquaresDp(number);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void test_numSquaresRec(int number, int expected) {
        int result = perfectSquares.numSquaresRec(number);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void test_numSquaresMemo(int number, int expected) {
        int result = perfectSquares.numSquaresMemo(number);
        assertEquals(expected, result);
    }

    static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(12, 3),
                Arguments.of(13, 2)
        );
    }
}