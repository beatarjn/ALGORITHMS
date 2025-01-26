package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MergeStringsAlternatelyTest {

    private final MergeStringsAlternately merge = new MergeStringsAlternately();

    @ParameterizedTest
    @MethodSource("testData")
    void mergeAlternately(String s1, String s2, String expected) {
        String result = merge.mergeAlternately(s1, s2);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("abc", "pqr", "apbqcr"),
                Arguments.of("ab", "pqrs", "apbqrs"),
                Arguments.of("abcd", "pq", "apbqcd")
        );
    }
}