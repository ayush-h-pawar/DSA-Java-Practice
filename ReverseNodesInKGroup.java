public class ReverseNodesInKGroup {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    static ListNode reverseKGroup(ListNode head, int k) {

        ListNode curr = head;
        int count = 0;

        // Check if at least k nodes exist
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        if (count == k) {

            ListNode prev = null;
            ListNode current = head;

            for (int i = 0; i < k; i++) {
                ListNode nextNode = current.next;
                current.next = prev;
                prev = current;
                current = nextNode;
            }

            head.next = reverseKGroup(current, k);
            return prev;
        }

        return head;
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

        head = reverseKGroup(head, 2);
        print(head);
    }
}
