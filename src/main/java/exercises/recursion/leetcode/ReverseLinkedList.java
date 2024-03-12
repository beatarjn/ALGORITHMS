package exercises.recursion.leetcode;

import exercises.Node;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedList {
    public Node reverseList(Node head) {
        List<Node> temp = new ArrayList<>();
        Node result = new Node();
        Node current = result;
        while (head != null) {
            temp.add(head);
            head = head.next;
        }

        if (temp.isEmpty()) {
            return null;
        }
        for (int i = temp.size() - 1; i >= 0; i--) {
            current.val = temp.get(i).val;
            if (i == 0) {
                current.next = null;
            } else {
                current.next = temp.get(i - 1);
            }
            current = current.next;
        }
        return result;
    }

}