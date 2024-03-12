package exercises.recursion.leetcode;

import exercises.Node;

import java.util.ArrayList;
import java.util.List;

public class LinkedListCycle {

    public boolean hasCycle(Node head) {
        List<Node> temp = new ArrayList<>();

        while (head != null) {
            if (temp.contains(head.next)){
                return true;
            } else {
                temp.add(head);
                head = head.next;
            }
        }
        return false;
    }
}
