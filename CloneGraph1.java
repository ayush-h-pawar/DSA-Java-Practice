import java.util.*;

public class CloneGraph1 {

    static class Node {
        int val;
        List<Node> neighbors = new ArrayList<>();

        Node(int val) {
            this.val = val;
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

        for (Node nei : node.neighbors) {
            copy.neighbors.add(dfs(nei, map));
        }

        return copy;
    }
}
