package exercises;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestCommonSubstringTest {

    private final LongestCommonSubstring longestCommonSubstring = new LongestCommonSubstring();

    @ParameterizedTest
    @MethodSource("provideTestData")
    void lcsLength(String text1, String text2, int expected) {
        int result = longestCommonSubstring.lcsLength(text1, text2);
        assertEquals(expected, result);
    }

    static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of("abcde", "abced", 3),
                Arguments.of("abcde", "g", 0),
                Arguments.of("abcde", "adeg", 2),
                Arguments.of("aaa", "aaa", 3),
                Arguments.of("dabaa", "daaab", 2)
        );
    }
}