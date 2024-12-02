package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubstringWithConcatenationOfAllWordsTest {

    private final SubstringWithConcatenationOfAllWords substring = new SubstringWithConcatenationOfAllWords();

    @ParameterizedTest
    @MethodSource("provideTestData")
    void findSubstring(String s, String[] words, List<Integer> expected) {
        List<Integer> result = substring.findSubstring(s, words);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void findSubstring1(String s, String[] words, List<Integer> expected) {
        List<Integer> result = substring.findSubstring1(s, words);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void findSubstring2(String s, String[] words, List<Integer> expected) {
        List<Integer> result = substring.findSubstring2(s, words);
        assertEquals(expected, result);
    }


    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of("barfoothefoobarman", new String[]{"foo", "bar"}, List.of(0, 9)),
                Arguments.of("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"}, Collections.emptyList()),
                Arguments.of("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}, List.of(6, 9, 12))
        );
    }

}