package exercises;

import exercises.MergeSortedLinkedLists;
import exercises.Node;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MergeSortedLinkedListsTest {
    private static Node list1 = new Node(1, new Node(3, new Node(7, null)));
    private static Node list2 = new Node(2, new Node(4, new Node(5, new Node(9, null))));
    private static Node list3 = new Node(0, null);
    private static Node list4 = new Node(0, null);
    private static Node list5 = new Node(9, new Node(9, new Node(9, new Node(9, null))));
    private static Node list6 = new Node(9, new Node(9, new Node(9, null)));
    private static Node list7 = new Node(2, new Node(4, new Node(9, null)));
    private static Node list8 = new Node(4, new Node(5, new Node(6, new Node(9, null))));
    private static Node list9 = new Node(1, new Node(9, new Node(9, null)));
    private static Node list10 = new Node(1, null);

    private MergeSortedLinkedLists mergeSortedLinkedLists = new MergeSortedLinkedLists();

    @ParameterizedTest
    @MethodSource("provideTestData")
    void merge(Node list1, Node list2, Node expected) {
        Node result = mergeSortedLinkedLists.merge(list1, list2);
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> provideTestData() {
        Node result1 = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, new Node(7, new Node(9)))))));
        Node result2 = new Node(0, new Node(0));
        Node result3 = new Node(9, new Node(9, new Node(9, new Node(9, new Node(9, new Node(9, new Node(9)))))));
        Node result4 = new Node(2, new Node(4, new Node(4, new Node(5, new Node(6, new Node(9, new Node(9, null)))))));
        Node result5 = new Node(1, new Node(1, new Node(9, new Node(9))));

        return Stream.of(
                Arguments.of(list1, list2, result1),
                Arguments.of(list3, list4, result2),
                Arguments.of(list5, list6, result3),
                Arguments.of(list7, list8, result4),
                Arguments.of(list9, list10, result5)
        );
    }
}