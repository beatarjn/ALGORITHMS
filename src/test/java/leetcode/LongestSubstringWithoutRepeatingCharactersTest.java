package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestSubstringWithoutRepeatingCharactersTest {

    private final LongestSubstringWithoutRepeatingCharacters longest = new LongestSubstringWithoutRepeatingCharacters();

    @ParameterizedTest
    @MethodSource("testData")
    void lengthOfLongestSubstring(String s, int expected) {
        int result = longest.lengthOfLongestSubstring(s);
        assertEquals(expected, result);

    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("abcabcbb", 3),
                Arguments.of("bbbbb", 1),
                Arguments.of("pwwkew", 3),
                Arguments.of("tmmzuxt", 5)
        );
    }
}