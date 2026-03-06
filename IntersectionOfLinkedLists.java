public class IntersectionOfLinkedLists {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null)
            return null;

        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != p2) {

            p1 = (p1 == null) ? headB : p1.next;
            p2 = (p2 == null) ? headA : p2.next;
        }

        return p1;
    }

    public static void main(String[] args) {

        ListNode common = new ListNode(8);
        common.next = new ListNode(10);

        ListNode headA = new ListNode(3);
        headA.next = new ListNode(7);
        headA.next.next = common;

        ListNode headB = new ListNode(99);
        headB.next = common;

        ListNode result = getIntersectionNode(headA, headB);

        if (result != null)
            System.out.println("Intersection at node: " + result.val);
        else
            System.out.println("No intersection");
    }
}
