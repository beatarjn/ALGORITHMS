package exercises;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubsetSumEqualsTargetTest {

    private SubsetSumEqualsTarget subsetSumEqualsTarget = new SubsetSumEqualsTarget();

    @ParameterizedTest
    @MethodSource("provideTestData")
    void test_subsetSumTo(boolean expected, int target, int[] arr) {
        boolean result = subsetSumEqualsTarget.subsetSumToTarget(target, arr);

        assertEquals(expected, result);
    }

    static Stream provideTestData() {
        return Stream.of(
                Arguments.of(true, 4, new int[]{2, 3, 1, 1}),
                Arguments.of(true, 5, new int[]{0, 5, 0}),
                Arguments.of(true, 7, new int[]{2, 3, 1, 1}),
                Arguments.of(false, 15, new int[]{2, 3, 1, 1})
        );
    }
}