package exercises;

import exercises.Node;

public class MergeSortedLinkedLists {

    // As input you get two sorted lists created from the Node class(int val, Node next).
    // Return a new list of Nodes composed of the given two lists merged and sorted.
//    Node merge(Node list1, Node list2)
//    Example:
//    Node list1 = new Node(1, new Node(3, new Node(7, null)))
//    Node list2 = new Node(2, new Node(4, new Node(5, new Node(9, null))))
//    Node result = merge(list1, list2)
//    result == Node(1, Node(2), Node(3), Node(4), Node(5), Node(7), Node(9)))))));

    public Node merge(Node l1, Node l2) {
        Node result = new Node();
        Node current = result;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                current.next = l2;
                l2 = l2.next;
            } else {
                current.next = l1;
                l1 = l1.next;
            }
            current = current.next;
        }

        while (l1 != null) {
            current.next = l1;
            l1 = l1.next;
            current = current.next;
        }

        while (l2 != null) {
            current.next = l2;
            l2 = l2.next;
            current = current.next;
        }
        return result.next;
    }
}