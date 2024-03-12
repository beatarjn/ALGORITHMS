package exercises.recursion.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BalancedTree {

    public Node balanceBST(Node root, Integer newElement) {
        List<Integer> list = traverse(root, new ArrayList<>());

        list.add(newElement);
        Collections.sort(list);

        return createBST(list, 0, list.size() - 1);
    }

    private List<Integer> traverse(Node node, List<Integer> list) {
        if (node != null) {
            list.add(node.getNodeNumber());
            traverse(node.getLeftNode(), list);
            traverse(node.getRightNode(), list);
        }
        return list;
    }

    private Node createBST(List<Integer> list, int low, int high) {
        if (low > high) {
            return null;
        }

        int mid = (low + high) / 2;

        Node node = new Node(list.get(mid));
        node.setLeftNode(createBST(list, low, mid - 1));
        node.setRightNode(createBST(list, mid + 1, high));

        return node;
    }

}