import java.util.HashMap;
import java.util.Map;

public class CopyRandomLinkedList {

    static class Node {

        int value;
        Node next;
        Node random;

        Node(int value) {
            this.value = value;
        }
    }

    public Node copyRandomList(
            Node head) {

        if (head == null) {
            return null;
        }

        Map<Node, Node> copies =
                new HashMap<>();

        Node current = head;

        while (current != null) {

            copies.put(
                    current,
                    new Node(current.value)
            );

            current = current.next;
        }

        current = head;

        while (current != null) {

            Node copy =
                    copies.get(current);

            copy.next =
                    copies.get(current.next);

            copy.random =
                    copies.get(current.random);

            current = current.next;
        }

        return copies.get(head);
    }

    public void printList(Node head) {

        while (head != null) {

            System.out.print(
                    head.value + " "
            );

            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        CopyRandomLinkedList solver =
                new CopyRandomLinkedList();

        Node first = new Node(7);
        Node second = new Node(13);
        Node third = new Node(11);
        Node fourth = new Node(10);
        Node fifth = new Node(1);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        first.random = null;
        second.random = first;
        third.random = fifth;
        fourth.random = third;
        fifth.random = first;

        Node copy =
                solver.copyRandomList(first);

        solver.printList(copy);
    }
}
