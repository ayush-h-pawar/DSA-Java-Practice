public class FlattenMultilevelDoublyList {

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        Node(int val) {
            this.val = val;
        }
    }

    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }

        flattenList(head);
        return head;
    }

    private Node flattenList(Node head) {
        Node current = head;
        Node last = head;

        while (current != null) {
            Node next = current.next;

            if (current.child != null) {
                Node childHead = current.child;
                Node childTail = flattenList(childHead);

                current.next = childHead;
                childHead.prev = current;

                if (next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }

                current.child = null;
                last = childTail;
            } else {
                last = current;
            }

            current = next;
        }

        return last;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(d), where d is maximum nesting depth
// LeetCode: 430 - Flatten a Multilevel Doubly Linked List
