import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphCloneDFS {

    static class Node {

        int val;
        List<Node> neighbors;

        Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        Node(int val) {
            this.val = val;
            neighbors = new ArrayList<>();
        }

        Node(int val, List<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }

    private final Map<Node, Node> clonedNodes =
            new HashMap<>();

    public Node cloneGraph(Node node) {

        if (node == null) {
            return null;
        }

        if (clonedNodes.containsKey(node)) {
            return clonedNodes.get(node);
        }

        Node clone =
                new Node(node.val);

        clonedNodes.put(node, clone);

        for (Node neighbor : node.neighbors) {

            clone.neighbors.add(
                    cloneGraph(neighbor)
            );
        }

        return clone;
    }

    public static void main(String[] args) {

        GraphCloneDFS solver =
                new GraphCloneDFS();

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        Node cloned =
                solver.cloneGraph(node1);

        System.out.println(
                "Original Node: " + node1.val
        );

        System.out.println(
                "Cloned Node: " + cloned.val
        );

        System.out.println(
                "Neighbors of Cloned Node: "
                        + cloned.neighbors.size()
        );
    }
}
