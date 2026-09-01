public class RemoveNthNodeLinkedList {

    static class ListNode {

        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    public ListNode removeNthFromEnd(
            ListNode head,
            int n) {

        ListNode dummy =
                new ListNode(0);

        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {

            fast = fast.next;
            slow = slow.next;
        }

        slow.next =
                slow.next.next;

        return dummy.next;
    }

    public void printList(ListNode head) {

        while (head != null) {

            System.out.print(
                    head.value + " "
            );

            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        RemoveNthNodeLinkedList solver =
                new RemoveNthNodeLinkedList();

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

        head = solver.removeNthFromEnd(
                head,
                2
        );

        solver.printList(head);
    }
}
