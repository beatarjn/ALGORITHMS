package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountPrimesTest {

    private CountPrimes countPrimes = new CountPrimes();

    @ParameterizedTest
    @MethodSource("provideTestData")
    void countPrimes(int n, int expected) {
        int result = countPrimes.countPrimes(n);
        assertEquals(expected, result);
    }

    static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(10, 4),
                Arguments.of(0, 0),
                Arguments.of(1, 0)
        );
    }
}