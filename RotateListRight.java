public class RotateListRight {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int length = 1;
        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        k %= length;

        if (k == 0) {
            return head;
        }

        // Make the list circular
        tail.next = head;

        int steps = length - k;
        ListNode newTail = tail;

        while (steps-- > 0) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
// LeetCode: 61 - Rotate List
