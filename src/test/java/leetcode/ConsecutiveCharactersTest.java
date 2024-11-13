package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConsecutiveCharactersTest {

    private final ConsecutiveCharacters consecutiveCharacters = new ConsecutiveCharacters();

    @ParameterizedTest
    @MethodSource("testData")
    void maxPower(String s, int expected) {
        int result = consecutiveCharacters.maxPower(s);

        assertEquals(expected, result);
    }

    public static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("leetcode", 2),
                Arguments.of("abbcccddddeeeeedcba", 5)
        );
    }
}