package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseIntegerTest {

    private ReverseInteger reverseInteger = new ReverseInteger();

    @ParameterizedTest
    @MethodSource("provideTestData")
    void reverse(int x, int expected) {

        int reversed = reverseInteger.reverse(x);
        assertEquals(expected, reversed);
    }

    static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(123, 321),
                Arguments.of(-123, -321),
                Arguments.of(120, 21),
                Arguments.of(-2147483648, 0)
        );
    }
}