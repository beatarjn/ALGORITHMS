package exercises.recursion.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NonOverlappingLineSegmentsTest {

    private NonOverlappingLineSegments segments = new NonOverlappingLineSegments();

    @ParameterizedTest
    @MethodSource("provideTestData")
    void numberOfSets1(int n, int k, int expected) {
        int result = segments.numberOfSets1(n, k);
        assertEquals(expected, result);
    }

    static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(4, 2, 5),
                Arguments.of(3, 1, 1),
                Arguments.of(30, 7, 796297179)
        );
    }
}