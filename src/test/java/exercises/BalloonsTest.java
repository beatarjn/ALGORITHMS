package exercises;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BalloonsTest {

    private Balloons balloons = new Balloons();

    @ParameterizedTest
    @MethodSource("provideTestData")
    void getMaxRec(int[] nums, int expected) {
        int result = balloons.getMaxRecValue(nums);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void getMaxDp(int[] nums, int expected) {
        int result = balloons.getMaxDpValue(nums);
        assertEquals(expected, result);
    }

    static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(new int[]{2, 7, 9, 3, 1}, 12),
                Arguments.of(new int[]{1, 2, 3, 1}, 4));
    }
}