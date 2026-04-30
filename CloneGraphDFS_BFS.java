import java.util.*;

public class CloneGraphDFS_BFS {

    static class Node {
        int val;
        List<Node> neighbors;

        Node(int val) {
            this.val = val;
            neighbors = new ArrayList<>();
        }
    }

    // DFS version
    static Node cloneDFS(Node node, Map<Node, Node> map) {

        if (node == null) return null;

        if (map.containsKey(node))
            return map.get(node);

        Node copy = new Node(node.val);
        map.put(node, copy);

        for (Node nei : node.neighbors) {
            copy.neighbors.add(cloneDFS(nei, map));
        }

        return copy;
    }

    // BFS version
    static Node cloneBFS(Node node) {

        if (node == null) return null;

        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        queue.offer(node);
        map.put(node, new Node(node.val));

        while (!queue.isEmpty()) {

            Node curr = queue.poll();

            for (Node nei : curr.neighbors) {

                if (!map.containsKey(nei)) {
                    map.put(nei, new Node(nei.val));
                    queue.offer(nei);
                }

                map.get(curr).neighbors.add(map.get(nei));
            }
        }

        return map.get(node);
    }
}
