package exercises.recursion.leetcode;

import exercises.recursion.leetcode.AddTwoNumbersLinkedList.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class AddTwoNumbersLinkedListTest {

    private static ListNode list1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
    private static ListNode list2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));
    private static ListNode list3 = new ListNode(0, null);
    private static ListNode list4 = new ListNode(0, null);
    private static ListNode list5 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null)))))));
    private static ListNode list6 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null))));
    private static ListNode list7 = new ListNode(2, new ListNode(4, new ListNode(9, null)));
    private static ListNode list8 = new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(9, null))));
    private static ListNode list9 = new ListNode(9, new ListNode(9, new ListNode(1, null)));
    private static ListNode list10 = new ListNode(1, null);
    private AddTwoNumbersLinkedList linkedList = new AddTwoNumbersLinkedList();

    @ParameterizedTest
    @MethodSource("provideTestData")
    void addTwoNumbers(ListNode l1, ListNode l2, ListNode expected) {
        ListNode listNode = linkedList.addTwoNumbers(l1, l2);
        assertThat(listNode).isEqualTo(expected);
    }

    static Stream<Arguments> provideTestData() {
        ListNode result1 = new ListNode(7, new ListNode(0, new ListNode(8, null)));
        ListNode result2 = new ListNode(0, null);
        ListNode result3 = new ListNode(8, new ListNode(9, new ListNode(9, new ListNode(9,
                new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(1, null))))))));
        ListNode result4 = new ListNode(7, new ListNode(0, new ListNode(4, new ListNode(0, new ListNode(1)))));
        ListNode result5 = new ListNode(0, new ListNode(0, new ListNode(2, null)));

        return Stream.of(
                Arguments.of(list1, list2, result1),
                Arguments.of(list3, list4, result2),
                Arguments.of(list5, list6, result3),
                Arguments.of(list7, list8, result4),
                Arguments.of(list9, list10, result5)
        );
    }


}