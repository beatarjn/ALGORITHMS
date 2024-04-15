package exercises.dynamic_programming.knapsack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KnapsackImplTest {

    private KnapsackImpl knapsackImpl = new KnapsackImpl();

    @ParameterizedTest
    @MethodSource("provideTestdata")
    void testKnapsack(int[][] values, int target, int expected) {
        int result = knapsackImpl.getMaxValue(values, target);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideTestdata() {
        return Stream.of(
                Arguments.of(new int[][]{{5, 7}, {6, 8}, {4, 3}, {2, 7}}, 7, 14),
                Arguments.of(new int[][]{{5, 7}, {4, 3}, {3, 8}, {1, 4}}, 7, 12),
                Arguments.of(new int[][]{{5, 10}, {4, 3}, {3, 10}, {3, 4}}, 5, 10),
                Arguments.of(new int[][]{{1, 5}, {2, 10}, {3, 20}}, 3, 20)
        );
    }
}