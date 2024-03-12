package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CoinChangeTest {

    private CoinChange coinChange = new CoinChange();

    @ParameterizedTest
    @MethodSource("provideTestData")
    void coinChange(int[] coins, int amount, int expected) {
        int result = coinChange.coinChange(coins, amount);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void coinChange3(int[] coins, int amount, int expected) {
        int result = coinChange.coinChangeOptimized(coins, amount);
        assertEquals(expected, result);
    }

    static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(new int[]{2, 5, 10, 1}, 27, 4),
                Arguments.of(new int[]{2}, 3, -1),
                Arguments.of(new int[]{1}, 0, 0),
                Arguments.of(new int[]{1, 2, 5}, 11, 3)
        );
    }

}