import java.util.*;

public class CloneGraph {

    static class Node {
        int val;
        List<Node> neighbors;

        Node(int val) {
            this.val = val;
            neighbors = new ArrayList<>();
        }
    }

    static Node cloneGraph(Node node) {

        if (node == null) return null;

        Map<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }

    static Node dfs(Node node, Map<Node, Node> map) {

        if (map.containsKey(node))
            return map.get(node);

        Node copy = new Node(node.val);
        map.put(node, copy);

        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(dfs(neighbor, map));
        }

        return copy;
    }

    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);

        node1.neighbors.add(node2);
        node2.neighbors.add(node1);

        Node cloned = cloneGraph(node1);

        System.out.println(cloned.val); // 1
    }
}
