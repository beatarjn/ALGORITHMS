package exercises.recursion.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class HouseRobberTest {

    private HouseRobber houseRobber = new HouseRobber();

    @ParameterizedTest
    @MethodSource("provideTestData")
    void test_robRecursive(int[] nums, int expected) {
        int rob = houseRobber.rob(nums);
        assertEquals(expected, rob);
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void test_robMemo(int[] nums, int expected) {
        int rob = houseRobber.robMemo(nums);
        assertEquals(expected, rob);
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void test_robDp(int[] nums, int expected) {
        int rob = houseRobber.robDp(nums);
        assertEquals(expected, rob);
    }

    static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 1}, 4),
                Arguments.of(new int[]{1, 3, 1}, 3),
                Arguments.of(new int[]{2, 7, 9, 3, 1}, 12)
        );
    }
}