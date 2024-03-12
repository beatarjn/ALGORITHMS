package exercises;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubsetSumTest {

    private SubsetSum subsetSum = new SubsetSum();

    @ParameterizedTest
    @MethodSource("provideTestData")
    void test_subsetSumToK(boolean expected, int n, int k, int[] arr) {
        boolean result = subsetSum.subsetSumToK(n, k, arr);

        assertEquals(expected, result);
    }


    static Stream provideTestData() {
        return Stream.of(
                Arguments.of(true, 3, 4, new int[]{2, 3, 1, 1}),
                Arguments.of(true, 2, 5, new int[]{0, 5, 0}),
                Arguments.of(true, 3, 7, new int[]{2, 3, 1, 1}),
                Arguments.of(false, 3, 15, new int[]{2, 3, 1, 1})
        );
    }


}