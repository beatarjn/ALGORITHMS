package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PointsThatIntersectWithCarsTest {

    private final PointsThatIntersectWithCars points = new PointsThatIntersectWithCars();

    @ParameterizedTest
    @MethodSource("testData")
    void numberOfPoints(List<List<Integer>> nums, int expected) {
        int result = points.numberOfPoints(nums);
        assertEquals(expected,result);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(

                Arguments.of(List.of(
                        List.of(3, 6),
                        List.of(1, 5),
                        List.of(4, 7)
                ), 7),
                Arguments.of(List.of(
                        List.of(1, 3),
                        List.of(5, 8)
                ), 7)
        );

    }
}