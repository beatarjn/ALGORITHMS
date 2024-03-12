package exercises.recursion.leetcode;

import exercises.Node;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ReverseLinkedListTest {

    private ReverseLinkedList reverseLinkedList = new ReverseLinkedList();

    @ParameterizedTest
    @MethodSource("provideTestData")
    void reverseList(Node head, Node expected) {
        Node result = reverseLinkedList.reverseList(head);
        assertThat(result).isEqualTo(expected);
    }

    static Stream provideTestData() {
        Node list1 = new Node(2, new Node(4, new Node(3, null)));
        Node list2 = new Node();
        Node list3 = new Node(1, null);

        Node expected1 = new Node(3, new Node(4, new Node(2, null)));
        Node expected2 = new Node();
        Node expected3 = new Node(1, null);

        return Stream.of(
                Arguments.of(list1, expected1),
                Arguments.of(list2, expected2),
                Arguments.of(list3, expected3),
                Arguments.of(null, null)
        );
    }
}