package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumWindowSubstringTest {

    private final MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();

    @ParameterizedTest
    @MethodSource("testData")
    void minWindow(String s, String t, String expected) {
        String result = minimumWindowSubstring.minWindow(s, t);

        assertEquals(expected, result);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("ADOBECODEBANC", "ABC", "BANC"),
                Arguments.of("b", "b", "b"),
                Arguments.of("p", "aa", ""),
                Arguments.of("aa", "aa", "aa")
        );
    }
}