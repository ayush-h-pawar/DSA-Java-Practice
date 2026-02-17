public class LinkedListDelete {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node deleteByValue(Node head, int key) {
        if (head == null) return null;

        // If head needs to be deleted
        if (head.data == key)
            return head.next;

        Node temp = head;

        while (temp.next != null && temp.next.data != key) {
            temp = temp.next;
        }

        if (temp.next != null)
            temp.next = temp.next.next;

        return head;
    }

    static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);

        head = deleteByValue(head, 20);
        print(head);
    }
}
