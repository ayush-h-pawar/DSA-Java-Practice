import java.util.*;

public class CloneGraphTraversal {

    static class Node {

        int value;
        List<Node> neighbors;

        Node(int value) {
            this.value = value;
            neighbors = new ArrayList<>();
        }
    }

    public Node cloneGraph(Node node) {

        if (node == null) {
            return null;
        }

        Map<Node, Node> cloned =
                new HashMap<>();

        Queue<Node> queue =
                new ArrayDeque<>();

        cloned.put(
                node,
                new Node(node.value)
        );

        queue.offer(node);

        while (!queue.isEmpty()) {

            Node current =
                    queue.poll();

            for (Node neighbor :
                    current.neighbors) {

                if (!cloned.containsKey(
                        neighbor)) {

                    cloned.put(
                            neighbor,
                            new Node(
                                    neighbor.value
                            )
                    );

                    queue.offer(neighbor);
                }

                cloned.get(current)
                        .neighbors
                        .add(
                                cloned.get(neighbor)
                        );
            }
        }

        return cloned.get(node);
    }

    public static void main(String[] args) {

        CloneGraphTraversal solver =
                new CloneGraphTraversal();

        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);

        first.neighbors.add(second);
        first.neighbors.add(fourth);

        second.neighbors.add(first);
        second.neighbors.add(third);

        third.neighbors.add(second);
        third.neighbors.add(fourth);

        fourth.neighbors.add(first);
        fourth.neighbors.add(third);

        Node clone =
                solver.cloneGraph(first);

        System.out.println(
                clone.value
        );

        System.out.println(
                clone.neighbors.size()
        );
    }
}
