public class RemoveDuplicatesSortedListII {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode current = head;

        while (current != null) {
            boolean duplicate = false;

            while (current.next != null &&
                   current.val == current.next.val) {
                current = current.next;
                duplicate = true;
            }

            if (duplicate) {
                prev.next = current.next;
            } else {
                prev = prev.next;
            }

            current = current.next;
        }

        return dummy.next;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
// LeetCode: 82 - Remove Duplicates from Sorted List II
