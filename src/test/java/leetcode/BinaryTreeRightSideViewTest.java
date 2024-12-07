package leetcode;

import leetcode.BinaryTreeRightSideView.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreeRightSideViewTest {

    private final BinaryTreeRightSideView binaryTreeRightSideView = new BinaryTreeRightSideView();

    @ParameterizedTest
    @MethodSource("testData")
    void rightSideView(TreeNode node, List<Integer> expected) {
        List<Integer> result = binaryTreeRightSideView.rightSideView(node);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(node1(), List.of(1, 3, 4)),
                Arguments.of(node2(), List.of(1, 3, 4, 5)),
                Arguments.of(node3(), List.of(1, 3))
        );
    }

    public static TreeNode node1() {
        /**
         *                  1
         *               /    \
         *             /       \
         *            2         3
         *             \         \
         *              5         4
         *
         *
         **/

        var node5 = new TreeNode(5, null, null);
        var node4 = new TreeNode(4, null, null);
        var node3 = new TreeNode(3, null, node4);
        var node2 = new TreeNode(2, null, node5);
        return new TreeNode(1, node2, node3);
    }

    public static TreeNode node2() {
        /**
         *                  1
         *               /    \
         *             /       \
         *            2         3
         *           /
         *          4
         *         /
         *        5
         **/

        var node5 = new TreeNode(5, null, null);
        var node4 = new TreeNode(4, node5, null);
        var node3 = new TreeNode(3, null, null);
        var node2 = new TreeNode(2, node4, null);
        return new TreeNode(1, node2, node3);
    }

    public static TreeNode node3() {
        /**
         *                 1
         *                  \
         *                    \
         *                     3
         *
         *
         *
         *
         **/

        var node3 = new TreeNode(3, null, null);
        return new TreeNode(1, null, node3);
    }
}