public class ReverseLinkedListIterative {

    static class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    public ListNode reverseList(ListNode head) {

        ListNode previous = null;
        ListNode current = head;

        while (current != null) {

            ListNode nextNode = current.next;

            current.next = previous;

            previous = current;
            current = nextNode;
        }

        return previous;
    }

    public void printList(ListNode head) {

        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        ReverseLinkedListIterative solver =
                new ReverseLinkedListIterative();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        solver.printList(head);

        head = solver.reverseList(head);

        solver.printList(head);
    }
}
