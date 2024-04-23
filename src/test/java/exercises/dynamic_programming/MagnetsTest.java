package exercises.dynamic_programming;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MagnetsTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    void maxMagnetsForMoney(int[] availableMagnets, int money, int expected) {
        Magnets magnets = new Magnets();
        int result = magnets.maxMagnetsForMoney(availableMagnets, money);
        assertEquals(expected, result);
    }

    static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(new int[]{4, 6, 10}, 27, 24),
                Arguments.of(new int[]{6, 10, 3}, 27, 25)
        );
    }
}