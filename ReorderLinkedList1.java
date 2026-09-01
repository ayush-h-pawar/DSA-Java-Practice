public class ReorderLinkedList1 {

    static class ListNode {

        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    public void reorderList(
            ListNode head) {

        if (head == null
                || head.next == null) {
            return;
        }

        // Find the middle.
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null
                && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half.
        ListNode second =
                reverse(slow.next);

        slow.next = null;

        // Merge both halves.
        ListNode first = head;

        while (second != null) {

            ListNode firstNext =
                    first.next;

            ListNode secondNext =
                    second.next;

            first.next = second;
            second.next = firstNext;

            first = firstNext;
            second = secondNext;
        }
    }

    private ListNode reverse(
            ListNode head) {

        ListNode previous = null;
        ListNode current = head;

        while (current != null) {

            ListNode next =
                    current.next;

            current.next = previous;

            previous = current;
            current = next;
        }

        return previous;
    }

    public void printList(
            ListNode head) {

        while (head != null) {

            System.out.print(
                    head.value + " "
            );

            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        ReorderLinkedList solver =
                new ReorderLinkedList();

        ListNode head =
                new ListNode(1);

        head.next =
                new ListNode(2);

        head.next.next =
                new ListNode(3);

        head.next.next.next =
                new ListNode(4);

        head.next.next.next.next =
                new ListNode(5);

        solver.printList(head);

        solver.reorderList(head);

        solver.printList(head);
    }
}
