public class LinkedListInsert {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node insertAtBeginning(Node head, int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        return newNode;
    }

    static Node insertAtEnd(Node head, int data) {
        Node newNode = new Node(data);

        if (head == null)
            return newNode;

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        return head;
    }

    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = null;

        head = insertAtBeginning(head, 30);
        head = insertAtBeginning(head, 20);
        head = insertAtBeginning(head, 10);

        head = insertAtEnd(head, 40);
        head = insertAtEnd(head, 50);

        printList(head);
    }
}
