public class SwapNodesInPairs {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    static ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {

            ListNode first = prev.next;
            ListNode second = prev.next.next;

            // Swap
            first.next = second.next;
            second.next = first;
            prev.next = second;

            // Move pointer
            prev = first;
        }

        return dummy.next;
    }

    static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        head = swapPairs(head);
        print(head);
    }
}
