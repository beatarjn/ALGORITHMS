package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumPopulationYearTest {

    private final MaximumPopulationYear max = new MaximumPopulationYear();

    @ParameterizedTest
    @MethodSource("testData")
    void maximumPopulation(int[][] logs, int expected) {
        int result = max.maximumPopulation(logs);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][]{{1993,1999}, {2000,2010}}, 1993),
                Arguments.of(new int[][]{{1950,1961}, {1960,1971}, {1970,1981}}, 1960)
        );
    }
}