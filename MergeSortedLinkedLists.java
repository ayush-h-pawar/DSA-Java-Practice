public class MergeSortedLinkedLists {

    static class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    public ListNode mergeTwoLists(
            ListNode first,
            ListNode second) {

        ListNode dummy =
                new ListNode(0);

        ListNode current = dummy;

        while (first != null
                && second != null) {

            if (first.value <= second.value) {

                current.next = first;
                first = first.next;

            } else {

                current.next = second;
                second = second.next;
            }

            current = current.next;
        }

        if (first != null) {
            current.next = first;
        } else {
            current.next = second;
        }

        return dummy.next;
    }

    public void printList(ListNode head) {

        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        MergeSortedLinkedLists solver =
                new MergeSortedLinkedLists();

        ListNode first = new ListNode(1);
        first.next = new ListNode(2);
        first.next.next = new ListNode(4);

        ListNode second = new ListNode(1);
        second.next = new ListNode(3);
        second.next.next = new ListNode(4);

        ListNode result =
                solver.mergeTwoLists(
                        first,
                        second
                );

        solver.printList(result);
    }
}
