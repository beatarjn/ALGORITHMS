package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestCommonSubsequenceTest {

    private LongestCommonSubsequence lcs = new LongestCommonSubsequence();

    @ParameterizedTest
    @MethodSource("provideTestData")
    void longestCommonSubsequence(String text1, String text2, int expected) {
        int result = lcs.longestCommonSubsequence(text1, text2);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void longestCommonSubsequenceDp(String text1, String text2, int expected) {
        int result = lcs.longestCommonSubsequenceDp(text1, text2);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void longestCommonSubsequenceTab(String text1, String text2, int expected) {
        int result = lcs.longestCommonSubsequenceTab(text1, text2);
        assertEquals(expected, result);
    }

    static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of("abcde", "ace", 3),
                Arguments.of("abc", "abc", 3),
                Arguments.of("abc", "def", 0)
        );
    }

}