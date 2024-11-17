package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RepeatedDNASequencesTest {

    private final RepeatedDNASequences repeatedDNASequences = new RepeatedDNASequences();

    @ParameterizedTest
    @MethodSource("testData")
    void findRepeatedDnaSequences(String s, List<String> expected) {
        List<String> result = repeatedDNASequences.findRepeatedDnaSequences(s);

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("testData")
    void findRepeatedDnaSequencesII(String s, List<String> expected) {
        List<String> result = repeatedDNASequences.findRepeatedDnaSequencesII(s);

        assertEquals(expected, result);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT", List.of("AAAAACCCCC", "CCCCCAAAAA")),
                Arguments.of("AAAAAAAAAAAAA", List.of("AAAAAAAAAA")),
                Arguments.of("ABGT", Collections.emptyList()),
                Arguments.of("AAAAAAAAAAA", List.of("AAAAAAAAAA"))
        );
    }
}