public class LinkedListCycleDetector {

    static class ListNode {

        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    public boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null
                && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        LinkedListCycleDetector solver =
                new LinkedListCycleDetector();

        ListNode first =
                new ListNode(3);

        ListNode second =
                new ListNode(2);

        ListNode third =
                new ListNode(0);

        ListNode fourth =
                new ListNode(-4);

        first.next = second;
        second.next = third;
        third.next = fourth;

        // Create a cycle.
        fourth.next = second;

        System.out.println(
                solver.hasCycle(first)
        );
    }
}
