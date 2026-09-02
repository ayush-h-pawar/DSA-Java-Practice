public class AddTwoNumbersLinkedList1 {

    static class ListNode {

        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    public ListNode addTwoNumbers(
            ListNode first,
            ListNode second) {

        ListNode dummy =
                new ListNode(0);

        ListNode current = dummy;
        int carry = 0;

        while (first != null
                || second != null
                || carry != 0) {

            int sum = carry;

            if (first != null) {
                sum += first.value;
                first = first.next;
            }

            if (second != null) {
                sum += second.value;
                second = second.next;
            }

            current.next =
                    new ListNode(sum % 10);

            carry = sum / 10;
            current = current.next;
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

        AddTwoNumbersLinkedList solver =
                new AddTwoNumbersLinkedList();

        ListNode first =
                new ListNode(2);

        first.next =
                new ListNode(4);

        first.next.next =
                new ListNode(3);

        ListNode second =
                new ListNode(5);

        second.next =
                new ListNode(6);

        second.next.next =
                new ListNode(4);

        ListNode result =
                solver.addTwoNumbers(
                        first,
                        second
                );

        solver.printList(result);
    }
}
