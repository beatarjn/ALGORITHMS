package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CoinChangeIITest {

    private final CoinChangeII coinChangeII = new CoinChangeII();

    @ParameterizedTest
    @MethodSource("provideTestData")
    void change(int amount, int[] coins, int expected) {
        int result = coinChangeII.change(amount, coins);
        assertEquals(expected, result);
    }

    static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(5, new int[]{1, 2, 5}, 4),
                Arguments.of(3, new int[]{2}, 0),
                Arguments.of(10, new int[]{10}, 1)
        );
    }
}