package exercises;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class GenerateBinStringsTest {

    private final GenerateBinStrings generateBinStrings = new GenerateBinStrings();

    @ParameterizedTest
    @MethodSource("testData")
    void generateBinStrings(String temp, List<String> expected) {
        List<String> result = generateBinStrings.generateBinStrings(temp);
        assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("1??", Arrays.asList("111", "110", "101", "100")),
                Arguments.of("10?1??", Arrays.asList("100100", "100101", "100110", "100111", "101100", "101101", "101110", "101111"))
        );
    }

}