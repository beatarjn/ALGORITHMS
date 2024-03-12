package exercises.recursion.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HouseRobberIIITest {

    private HouseRobberIII houseRobber = new HouseRobberIII();

    @ParameterizedTest
    @MethodSource("provideTestData")
    void rob(HouseRobberIII.TreeNode root, int expected) {
        int rob = houseRobber.rob(root);
        assertEquals(expected, rob);
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void robMemo(HouseRobberIII.TreeNode root, int expected) {
        int rob = houseRobber.robMemo(root);
        assertEquals(expected, rob);
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void robDp(HouseRobberIII.TreeNode root, int expected) {
        int rob = houseRobber.dp(root);
        assertEquals(expected, rob);
    }

    static Stream<Arguments> provideTestData(){
        return Stream.of(
                Arguments.of(tree(), 7),
                Arguments.of(tree1(), 36),
                Arguments.of(tree2(), 9)
        );
    }

    public static HouseRobberIII.TreeNode tree() {
        var node4 = new HouseRobberIII.TreeNode(1, null, null);
        var node3 = new HouseRobberIII.TreeNode(3, null, null);
        var node2 = new HouseRobberIII.TreeNode(3, null, node4);
        var node1 = new HouseRobberIII.TreeNode(2, null, node3);
        var node0 = new HouseRobberIII.TreeNode(3, node1, node2);
        return node0;
    }

    public static HouseRobberIII.TreeNode tree1() {
        /**
         *                  0
         *               /     \
         *             /        \
         *           /           \
         *         /              \
         *       2                5
         *     /   \            /  \
         *    7     3         11      14
         *   / \   /
         *  8  6  15
         *
         *
         **/


        var node9 = new HouseRobberIII.TreeNode(15, null, null);
        var node8 = new HouseRobberIII.TreeNode(6, null, null);
        var node7 = new HouseRobberIII.TreeNode(8, null, null);
        var node6 = new HouseRobberIII.TreeNode(14, null, null);
        var node5 = new HouseRobberIII.TreeNode(11, null, null);
        var node4 = new HouseRobberIII.TreeNode(3, node9, null);
        var node3 = new HouseRobberIII.TreeNode(7, node7, node8);
        var node2 = new HouseRobberIII.TreeNode(5, node5, node6);
        var node1 = new HouseRobberIII.TreeNode(2, node3, node4);
        var node0 = new HouseRobberIII.TreeNode(0, node1, node2);
        return node0;
    }

    public static HouseRobberIII.TreeNode tree2() {
        var node5 = new HouseRobberIII.TreeNode(1, null, null);
        var node4 = new HouseRobberIII.TreeNode(3, null, null);
        var node3 = new HouseRobberIII.TreeNode(1, null, null);
        var node2 = new HouseRobberIII.TreeNode(5, node5, null);
        var node1 = new HouseRobberIII.TreeNode(4, node3, node4);
        var node0 = new HouseRobberIII.TreeNode(3, node1, node2);
        return node0;
    }
}