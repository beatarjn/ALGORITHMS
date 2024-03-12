package leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PalindromeNumberTest {

    private PalindromeNumber palindromeNumber = new PalindromeNumber();

    @ParameterizedTest
    @MethodSource("provideTestData")
    void isPalindromeString(int x, boolean expected) {
        boolean result = palindromeNumber.isPalindromeString(x);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void isPalindrome(int x, boolean expected) {
        boolean result = palindromeNumber.isPalindrome(x);
        assertEquals(expected, result);
    }

    static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(-121, false),
                Arguments.of(121, true),
                Arguments.of(10, false)
        );
    }
}