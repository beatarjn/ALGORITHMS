package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OnesAndZeroesTest {

    private final OnesAndZeroes onesAndZeroes = new OnesAndZeroes();

    @ParameterizedTest
    @MethodSource("provideTestData")
    void findMaxForm(String[] strs, int m, int n, int expected) {
        int result = onesAndZeroes.findMaxForm(strs, m, n);
        assertEquals(expected, result);
    }

    static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(new String[]{"10","0001","111001","1","0"}, 5, 3, 4),
                Arguments.of(new String[]{"10","0","1"}, 1, 1, 2)
        );
    }
}