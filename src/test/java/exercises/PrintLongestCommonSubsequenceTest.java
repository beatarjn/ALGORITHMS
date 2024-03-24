package exercises;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrintLongestCommonSubsequenceTest {

    private PrintLongestCommonSubsequence longestCommonSubsequence = new PrintLongestCommonSubsequence();

    @ParameterizedTest
    @MethodSource("provideTestData")
    void longestCommonSubsequence(String text1, String text2, String expected) {

        String result = longestCommonSubsequence.getLcs(text1, text2);
        assertEquals(expected, result);
    }

    static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of("abcde", "ace", "ace"),
                Arguments.of("abc", "abc", "abc"),
                Arguments.of("abc", "def", ""),
                Arguments.of("abcde", "bdgek", "bde"),
                Arguments.of("abcd", "efga", "a")
        );
    }
}